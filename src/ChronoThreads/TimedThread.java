package ChronoThreads;

/**
 * Created by sa on 09.06.17.
 */
public class TimedThread extends Thread {

    private ChronoThread chronoThread;
    private long interval;
    private long secondsPassed;

    public TimedThread(ChronoThread t, long interval) {
        this.chronoThread = t;
        this.interval = interval;
        this.secondsPassed = 0;
    }

    @Override
    public void run() {
        while( true ) {
            long seconds = this.chronoThread.secondsPassed();
            if ((seconds - secondsPassed) >= interval) {
                System.out.println("Прошло: " + this.interval);
                secondsPassed = seconds;
            }
        }
    }
}
