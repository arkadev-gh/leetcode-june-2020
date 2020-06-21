package dungeonGame;

public class DungeonGame {
    int[][] dungeon;
    int[][] minHealth;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0)
            return 1;

        this.dungeon = dungeon;
        this.minHealth = new int[dungeon.length][dungeon[0].length];
        return explore();
    }

    public int explore() {
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
                    minHealth[i][j] = Math.max(1 - dungeon[i][j], 1);

                else {
                    int right = Integer.MAX_VALUE;
                    int bottom = Integer.MAX_VALUE;

                    if (j < dungeon[0].length - 1) right = Math.max(minHealth[i][j + 1] - dungeon[i][j], 1);
                    if (i < dungeon.length - 1) bottom = Math.max(minHealth[i + 1][j] - dungeon[i][j], 1);
                    minHealth[i][j] = Math.min(right, bottom);
                }
            }
        }
        return minHealth[0][0];
    }
}
