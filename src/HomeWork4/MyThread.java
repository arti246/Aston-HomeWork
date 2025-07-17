package HomeWork4;

public class MyThread implements Runnable{
    private final String message;
    private final Object lock;
    private final boolean initialTurn; // Начальное значение флага
    private static boolean currentTurn = true; // Общий статический флаг для всех потоков

    public MyThread(String message, Object lock, boolean initialTurn) {
        this.message = message;
        this.lock = lock;
        this.initialTurn = initialTurn;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    // Ждём, пока не наступит наша очередь
                    while (currentTurn != initialTurn) {
                        lock.wait();
                    }
                    System.out.println(message);
                    Thread.sleep(500);
                    currentTurn = !currentTurn;
                    lock.notifyAll(); // Будим все ожидающие потоки
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
