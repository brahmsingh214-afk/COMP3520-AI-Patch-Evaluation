public final class Visible {
    public static void main(String[] args) {
        check("/srv/app", "/srv/application/a", false);
    }

    static void check(String base, String candidate, boolean expected) {
        boolean actual = PathCheck.contains(base, candidate);
        if (actual != expected) {
            throw new AssertionError(candidate + ": expected " + expected + ", got " + actual);
        }
    }
}
