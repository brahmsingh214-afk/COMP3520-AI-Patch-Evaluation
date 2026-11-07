public final class Visible {
    public static void main(String[] args) {
        double actual = Average.mean(2, 3);
        if (actual != 2.5) throw new AssertionError("Expected 2.5, got " + actual);
    }
}
