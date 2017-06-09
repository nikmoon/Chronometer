package ChronoThreads;

/**
 * Created by sa on 09.06.17.
 */
public class ChronoThread extends Thread {

    private long startMillis;
    private long secPassed;
    public volatile boolean stopThread;

    public ChronoThread(long startMillis) {
        this.startMillis = startMillis;
        this.stopThread = false;
    }

    synchronized long secondsPassed() {
        try {
            wait();
        }
        catch (InterruptedException ex) {
            System.exit(-1);
        }
        return secPassed;
    }

    synchronized void notifySecondsPassed() {
        notifyAll();
    }

    @Override
    public void run() {
        long currMillis;
        try {
            while (!this.stopThread) {
                Thread.sleep(1000);
                currMillis = System.currentTimeMillis();
                this.secPassed = (currMillis - startMillis) / 1000;
                this.notifySecondsPassed();
                System.out.println("От начала сессии прошло: " + secPassed);
            }
        }
        catch (InterruptedException ex) {
            System.out.println("Interrupted exception in ChronoThread");
            System.exit(-1);
        }
    }

    public long getStartMillis() {
        return startMillis;
    }
}
