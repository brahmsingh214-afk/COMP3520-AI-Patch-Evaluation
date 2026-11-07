public final class Visible {
    public static void main(String[] args) {
        check("photo.JPG", true);
        check("photo.jpg", true);
    }

    static void check(String name, boolean expected) {
        boolean actual = Photo.isJpg(name);
        if (actual != expected) {
            throw new AssertionError(name + ": expected " + expected + ", got " + actual);
        }
    }
}
