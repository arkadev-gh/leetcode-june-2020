package coinChange2;

public class CoinChange2 {
    int[][] numWays;
    int amount;
    int[] coins;

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;

        this.amount = amount;
        this.coins = coins;
        this.numWays = new int[coins.length + 1][amount + 1];

        return getNumWays();
    }

    public int getNumWays() {
        // Base case
        for (int i = 0; i <= coins.length; i++)
            numWays[i][0] = 1;

        // For each denomination
        for (int i = 1; i <= coins.length; i++) {
            // For every amount possible
            for (int j = 1; j <= amount; j++) {
                numWays[i][j] = numWays[i - 1][j];
                if (j - coins[i - 1] >= 0)
                    numWays[i][j] += numWays[i][j - coins[i - 1]];
            }
        }
        return numWays[coins.length][amount];
    }
}
