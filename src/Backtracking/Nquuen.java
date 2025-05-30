package Backtracking;

public class Nquuen {
    public static void main(String[] args) {
        int n = 12;  // Try 14, 15, even 16
        long start = System.nanoTime();

        int solutions = totalNQueens(n);

        long end = System.nanoTime();
        System.out.println("Total solutions: " + solutions);
        System.out.printf("Execution Time: %.4f ms%n", (end - start) / 1_000_000.0);
    }

    public static int totalNQueens(int n) {
        return solve(0, 0, 0, 0, n);
    }

    private static int solve(int row, int cols, int diagonals1, int diagonals2, int n) {
        if (row == n) return 1;

        int count = 0;
        int availablePositions = (~(cols | diagonals1 | diagonals2)) & ((1 << n) - 1);

        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions; // rightmost 1-bit
            availablePositions &= availablePositions - 1;            // remove that bit

            count += solve(
                    row + 1,
                    cols | position,
                    (diagonals1 | position) << 1,
                    (diagonals2 | position) >> 1,
                    n
            );
        }

        return count;
    }
}