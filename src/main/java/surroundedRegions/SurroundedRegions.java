package surroundedRegions;

public class SurroundedRegions {
    boolean[][] visited;
    char[][] board;
    int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;

        this.board = board;
        this.visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
                        && !visited[i][j])
                    performDfs(i, j);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
    }

    public void performDfs(int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || visited[i][j])
            return;

        visited[i][j] = true;

        for (int[] neighbour : neighbours) performDfs(i + neighbour[0], j + neighbour[1]);
    }
}
