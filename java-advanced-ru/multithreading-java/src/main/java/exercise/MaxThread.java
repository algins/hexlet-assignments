package exercise;

// BEGIN
import java.lang.Thread;
import java.util.Arrays;

public class MaxThread extends Thread {
    private final int[] numbers;
    private int maxNumber;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public void run() {
        maxNumber = Arrays.stream(numbers).max().getAsInt();
    }
}
// END
