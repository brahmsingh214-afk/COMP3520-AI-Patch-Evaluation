public final class Visible {
    public static void main(String[] args) {
        check(11, 5, 3);
    }

    static void check(int items, int pageSize, int expected) {
        int actual = Pages.count(items, pageSize);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }
}
