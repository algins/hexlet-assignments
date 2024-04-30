package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String reversedChars;

    public ReversedSequence(String chars) {
        this.reversedChars = new StringBuilder(chars).reverse().toString();
    }

    public String toString() {
        return reversedChars;
    }

    public char charAt(int index) {
        return reversedChars.charAt(index);
    }

    public int length() {
        return reversedChars.length();
    }

    public CharSequence subSequence(int start, int end) {
        return reversedChars.subSequence(start, end);
    }
}
// END
