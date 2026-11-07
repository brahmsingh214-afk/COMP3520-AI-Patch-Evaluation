public final class Visible {
    public static void main(String[] args) {
        check(100, 4, 500, 500);
    }

    static void check(int base, int attempt, int cap, int expected) {
        int actual = Retry.delay(base, attempt, cap);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }
}
