public final class Visible {
    public static void main(String[] args) {
        check(10, Integer.MAX_VALUE, 1, false, 10, Integer.MAX_VALUE);
    }

    static void check(int source, int destination, int amount,
                      boolean expectedSuccess, int expectedSource, int expectedDestination) {
        int[] balances = {source, destination};
        boolean success = Transfer.move(balances, amount);
        if (success != expectedSuccess || balances[0] != expectedSource
                || balances[1] != expectedDestination) {
            throw new AssertionError("Expected " + expectedSuccess + " with balances ["
                + expectedSource + ", " + expectedDestination + "], got " + success
                + " with balances [" + balances[0] + ", " + balances[1] + "]");
        }
    }
}
