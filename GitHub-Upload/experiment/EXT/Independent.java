public final class Independent {
    public static void main(String[] args) {
        Visible.check("photo.JpG", true);
        Visible.check("photo.jpg.exe", false);
        Visible.check(".jpg", false);
    }
}
