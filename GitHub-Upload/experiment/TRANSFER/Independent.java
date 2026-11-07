public final class Independent {
    public static void main(String[] args) {
        Visible.check(10, 20, 10, true, 0, 30);
        Visible.check(3, 20, 4, false, 3, 20);
        Visible.check(1, Integer.MAX_VALUE - 1, 1, true, 0, Integer.MAX_VALUE);
    }
}
