package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var minThread = new MinThread(numbers);
        var maxThread = new MaxThread(numbers);

        startThread(minThread);
        startThread(maxThread);

        finishThread(minThread);
        finishThread(maxThread);

        return Map.of(
            "min", minThread.getMinNumber(),
            "max", maxThread.getMaxNumber()
        );
    }

    private static void startThread(Thread thread) {
        thread.start();
        LOGGER.log(Level.INFO, "Thread {0} started", thread.getName());
    }

    private static void finishThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LOGGER.log(Level.INFO, "Thread {0} finished", thread.getName());
    }
    // END
}
