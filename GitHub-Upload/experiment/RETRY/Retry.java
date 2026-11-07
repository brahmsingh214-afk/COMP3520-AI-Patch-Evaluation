public final class Retry {
    public static int delay(int base, int attempt, int cap) {
        return base << attempt;
    }
}
