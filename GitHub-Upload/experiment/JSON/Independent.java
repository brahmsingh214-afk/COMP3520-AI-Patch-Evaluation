public final class Independent {
    public static void main(String[] args) {
        Visible.check("");
        Visible.check("\"\\");
        Visible.check("\n\t" + (char) 0);
    }
}
