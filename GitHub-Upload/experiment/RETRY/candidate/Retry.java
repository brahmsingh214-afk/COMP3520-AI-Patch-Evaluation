public final class Retry {
    public static int delay(int base, int attempt, int cap) {
        if (attempt >= 31 || base > (cap >> attempt)) {
            return cap;
        }
        return base << attempt;
    }
}
