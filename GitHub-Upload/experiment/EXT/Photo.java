public final class Photo {
    public static boolean isJpg(String name) {
        return name.length() > 4 && name.endsWith(".jpg");
    }
}
