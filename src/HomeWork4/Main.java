package HomeWork4;

/*
* Программа для бесконечного вывода "1" и "2" с помощью двух потоков
*/

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread1 = new Thread(new MyThread("1", lock, true), "MyThread");
        Thread thread2 = new Thread(new MyThread("2", lock, false), "MyThread");
        thread1.start();
        thread2.start();
    }
}
