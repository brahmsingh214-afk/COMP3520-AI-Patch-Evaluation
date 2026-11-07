public final class Transfer {
    public static boolean move(int[] balances, int amount) {
        if (balances[0] < amount) return false;
        if (balances[1] > Integer.MAX_VALUE - amount) return false;
        balances[0] -= amount;
        balances[1] += amount;
        return true;
    }
}
