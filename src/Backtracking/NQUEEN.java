package Backtracking;

public class NQUEEN {
    public static void main(String[] args) {
        int n = 14;  // You can change this for different board sizes
        boolean[][] board = new boolean[n][n];

        long startTime = System.nanoTime(); // Start timing

        int solutions = queens(board, 0);

        long endTime = System.nanoTime(); // End timing

        System.out.println("Total solutions: " + solutions);
        System.out.printf("Execution Time: %.4f ms%n", (endTime - startTime) / 1_000_000.0);
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false; // backtrack
            }
        }
        return count;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean var : row) {
                System.out.print(var ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertical up
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check upper-left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) return false;
        }

        // Check upper-right diagonal
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }
}