package HomeWork3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Программа считывет данные из файла, где представлена информация по продуктам на складе в виде:
* ПРОДУКТ(String) ЦЕНА(double) КОЛИЧЕСТВО(int)
* И создаёт новый файл с отчётом по продкутам
* */

public class Main {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\artur\\IdeaProjects\\Aston-HomeWork\\src\\HomeWork3\\products.txt";
        String outputFile = "C:\\Users\\artur\\IdeaProjects\\Aston-HomeWork\\src\\HomeWork3\\report.txt";

        try {
            List<Product> products = getProductFromFile(inputFile);
            double totalCost = calculateTotalCost(products);
            Product mostExpensive = findMostExpensiveProduct(products);
            Product largestQuantity = findLargestQuantityProduct(products);
            writeReport(outputFile, totalCost, mostExpensive, largestQuantity);
        } catch (MyException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка файла: " + e.getMessage());
        }
    }

    public static List<Product> getProductFromFile(String path) throws IOException {
        List<String> linesFromFile = Files.readAllLines(Paths.get(path));
        if (linesFromFile.isEmpty()) {
            throw new MyException("Файл пуст!");
        }

        List<Product> products = new ArrayList<>();
        for (String product : linesFromFile) {
            String[] words = product.split("\\s+");
            if (words.length != 3) {
                throw new MyException("Некорректный формат строки: " + product);
            }
            try {
                products.add(new Product(words[0], Double.parseDouble(words[1]), Integer.parseInt(words[2])));
            } catch (NumberFormatException e) {
                throw new MyException("Ошибка парсинга числа в строке: " + product);
            }
        }
        return products;
    }

    public static double calculateTotalCost(List<Product> products) {
        return products.stream().mapToDouble(Product::getTotalCost)
                .sum();
    }

    public static Product findMostExpensiveProduct(List<Product> products) {
        return products.stream().max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
    }

    public static Product findLargestQuantityProduct(List<Product> products) {
        return products.stream().max(Comparator.comparingInt(Product::getCount))
                .orElse(null);
    }

    public static void writeReport(String path, double totalCost, Product mostExpensive,
                                      Product largestQuantity) throws IOException {
        try {
            String report = String.format(
                    "Общий отчет:\n" +
                            "- Общая стоимость всех товаров: %.1f руб.\n" +
                            "- Самый дорогой товар: %s (%.1f руб./шт.)\n" +
                            "- Товар с максимальным количеством: %s (%d шт.)",
                    totalCost,
                    mostExpensive.getName(),
                    mostExpensive.getPrice(),
                    largestQuantity.getName(),
                    largestQuantity.getCount()
            );
            Files.write(Paths.get(path), report.getBytes());
            System.out.println("Данные записаны в файл!");
        } catch (IOException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
        }
    }
}