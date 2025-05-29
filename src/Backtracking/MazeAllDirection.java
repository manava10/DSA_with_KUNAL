package Backtracking;
public class MazeAllDirection {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        findAllPaths("", board, 0, 0);
        System.out.println();
        System.out.println("The total no of path is" + CountPath("",board,0,0));
    }

    static void findAllPaths(String path, boolean[][] maze, int r, int c) {
        // Base condition: reached the bottom-right cell
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        // If the current cell is already visited or blocked
        if (!maze[r][c]) {
            return;
        }

        // Mark the cell as visited
        maze[r][c] = false;

        // Move Down
        if (r < maze.length - 1) {
            findAllPaths(path + "d", maze, r + 1, c);
        }

        // Move Right
        if (c < maze[0].length - 1) {
            findAllPaths(path + "R", maze, r, c + 1);
        }

        // Move Up
        if (r > 0) {
            findAllPaths(path + "u", maze, r - 1, c);
        }

        // Move Left
        if (c > 0) {
            findAllPaths(path + "L", maze, r, c - 1);
        }

        // Backtrack: unmark the cell before returning
        maze[r][c] = true;
    }
    static int CountPath(String path, boolean[][] maze, int r, int c) {
        // Base condition: reached the bottom-right cell
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            return 1;
        }

        // If the current cell is already visited or blocked
        if (!maze[r][c]) {
            return 0;
        }

        // Mark the cell as visited
        maze[r][c] = false;
        int k=0;int l=0; int m =0; int n=0;

        // Move Down
        if (r < maze.length - 1) {
            k = CountPath(path + "d", maze, r + 1, c);
        }

        // Move Right
        if (c < maze[0].length - 1) {
             l = CountPath(path + "R", maze, r, c + 1);
        }

        // Move Up
        if (r > 0) {
             m = CountPath(path + "u", maze, r - 1, c);
        }

        // Move Left
        if (c > 0) {
             n = CountPath(path + "L", maze, r, c - 1);
        }

        // Backtrack: unmark the cell before returning
        maze[r][c] = true;
        return (k+l+m+n);
    }
}
//This is the first code of this type. To include the diagonal Path , I have also written a second version of this Code;
//Make a change and revert a Change.