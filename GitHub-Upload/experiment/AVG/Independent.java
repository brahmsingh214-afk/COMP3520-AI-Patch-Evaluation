public final class Independent {
    public static void main(String[] args) {
        check(-3, -2, -2.5);
        check(Integer.MAX_VALUE, Integer.MAX_VALUE, 2147483647.0);
        check(Integer.MIN_VALUE, Integer.MAX_VALUE, -0.5);
    }

    private static void check(int a, int b, double expected) {
        double actual = Average.mean(a, b);
        if (actual != expected) {
            throw new AssertionError("Inputs " + a + ", " + b
                + ": expected " + expected + ", got " + actual);
        }
    }
}
