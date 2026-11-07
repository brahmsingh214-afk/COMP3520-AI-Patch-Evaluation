public final class Independent {
    public static void main(String[] args) {
        Visible.check("/srv/app", "/srv/app/a", true);
        Visible.check("/srv/app", "/srv/app/../secret", false);
        Visible.check("/srv/app", "/srv/app", true);
    }
}
