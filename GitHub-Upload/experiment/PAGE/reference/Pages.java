public final class Pages {
    public static int count(int items, int pageSize) {
        return (int) ((items + (long) pageSize - 1) / pageSize);
    }
}
