package cs1302.threads;

/**
 * Driver for thread example.
 */
public class ThreadDriver {

    public static void main(String[] args) {
        runNow(() -> loop("###"));
        runNow(() -> loop("---"));
        System.err.println("main thread is done.");
    } // main

    /**
     * Executes an infinite loop.
     * @param name loop name
     */
    public static void loop(String loopName) {
        int x = 0;
        while (true) {
            System.err.printf("%s-%d\n", loopName, x);
            x += 1;
        } // while
    } // loop

    /**
     * Creates and immediately starts a new daemon thread that executes
     * {@code target.run()}. This method, which may be called from any thread,
     * will return immediately its the caller.
     * @param target the object whose {@code run} method is invoked when this
     *               thread is started
     */
    public static void runNow(Runnable target) {
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.start();
    } // runNow

} // ThreadDriver
