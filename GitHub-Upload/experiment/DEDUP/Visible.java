import java.util.Arrays;

public final class Visible {
    public static void main(String[] args) {
        check(new int[]{3, 1, 2}, Dedup.unique(new int[]{3, 1, 3, 2}));
    }

    static void check(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError("Expected " + Arrays.toString(expected)
                + ", got " + Arrays.toString(actual));
        }
    }
}
