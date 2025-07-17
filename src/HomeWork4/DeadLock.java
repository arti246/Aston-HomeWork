package HomeWork4;

/*
* Первый поток захватывает первый lock и спит 1 секунду. Пока он спит, срабатывает второй
* поток и захватывает второй lock и тоже засыпает на 1 секунду. Потом поток thread просыпается
* и пробует захватить второй lock, но он уже занят вторым потоком (в этот момент он просто ждёт,
* пока второй lock освободится). Потом второй поток пытается захватить первый lock, но он
* занят первым потоком и тоже ожидает его освобождения. Но этого не произойдёт
*/

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();  // Первый объект-блокировка
        Object lock2 = new Object();  // Второй объект-блокировка

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: захватил lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {
                    System.out.println("Thread 1: захватил lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: захватил lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1) {
                    System.out.println("Thread 2: захватил lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}