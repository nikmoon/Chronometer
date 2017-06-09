package nikpack;

import ChronoThreads.ChronoThread;
import ChronoThreads.TimedThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ChronoThread chronoThread = new ChronoThread(System.currentTimeMillis());
        TimedThread t5 = new TimedThread(chronoThread, 5);
        TimedThread t7 = new TimedThread(chronoThread, 7);
        chronoThread.start();
        t5.start();
        t7.start();
        Thread.sleep(50*1000);
        chronoThread.stopThread = true;
        t5.stopThread = true;
        t7.stopThread = true;
        chronoThread.join();
        t5.join();
        t7.join();
        System.out.println("Все потоки завершены");
    }
}
