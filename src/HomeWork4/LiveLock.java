package HomeWork4;

import java.util.concurrent.locks.ReentrantLock;

/*
* Первый поток пытается захватить первый lock и захватывает, ждёт 1 секунду. В это время срабатывает
* второй поток, пытается захватить второй lock и захватывает, ждёт 1 секунду. В это время просыпается
* первый потоки пробует захватить второй lock (с захваченным первым) и у него не получается, поэтому
* он особождает свой первый поток. После этого то же самое происходит и со вторым потоком. Программа
* закцикливается, потоки пытаются открыть lock-и друг для друга, но не сдвигаются с места из-за этого
*/

public class LiveLock {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            while (true) {
                if (lock1.tryLock()) {
                    System.out.println("Поток 1: захатил lock1");
                    try {
                        Thread.sleep(1000);
                        if (lock2.tryLock()) {
                            System.out.println("Поток 1: захватил lock2");
                            break;
                        } else {
                            System.out.println("Поток 1: не получил lock2, отпускаю lock1");
                            lock1.unlock();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (lock2.tryLock()) {
                    System.out.println("Поток 2: захатил lock2");
                    try {
                        Thread.sleep(1000);
                        if (lock1.tryLock()) {
                            System.out.println("Поток 2: захватил lock1");
                            break;
                        } else {
                            System.out.println("Поток 2: не получил lock1, отпускаю lock2");
                            lock2.unlock();
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}