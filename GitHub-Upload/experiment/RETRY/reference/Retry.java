public final class Retry {
    public static int delay(int base, int attempt, int cap) {
        long delay = base;
        for (int i = 0; i < attempt && delay < cap; i++) {
            delay *= 2;
        }
        return (int) Math.min(delay, cap);
    }
}
