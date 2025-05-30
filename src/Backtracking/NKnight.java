package Backtracking;

public class NKnight {

    static int[][] directions = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2}
    };

    public static void main(String[] args) {
        int n = 4;      // board size (n x n)
        int k = 8;      // number of knights to place
        boolean[][] board = new boolean[n][n];
        System.out.println(placeKnights(board, 0, 0, k));
    }

    public static int placeKnights(boolean[][] board, int row, int col, int knightsRemaining) {
        if (knightsRemaining == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        if (row == board.length) return 0;

        int count = 0;

        if (col == board.length) {
            count += placeKnights(board, row + 1, 0, knightsRemaining);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += placeKnights(board, row, col + 1, knightsRemaining - 1);
            board[row][col] = false;
        }

        // Skip placing a knight at current cell
        count += placeKnights(board, row, col + 1, knightsRemaining);
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        for (int[] dir : directions) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && y >= 0 && x < board.length && y < board.length) {
                if (board[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "K " : ". ");
            }
            System.out.println();
        }
    }
}