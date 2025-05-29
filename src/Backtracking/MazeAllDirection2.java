package Backtracking;
public class MazeAllDirection2 {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        findAllPaths("", board, 0, 0);
        System.out.println();
        System.out.println("The total no of path is :" + countPath("",board,0,0));
    }

    static void findAllPaths(String path, boolean[][] maze, int r, int c) {
        // Base condition: reached the bottom-right cell
        if(r==maze.length || c==maze[0].length || c<0 || r<0 ){
            return ;
        }
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
        findAllPaths(path + "(DW)", maze, r + 1, c);

        // Move Right
        findAllPaths(path + "(RG)", maze, r, c + 1);

        // Move Up
        findAllPaths(path + "(UP)", maze, r - 1, c);

        // Move Left
        findAllPaths(path + "(LF)", maze, r, c - 1);

        //This is to Print The Diagonal

        findAllPaths(path+"(DG)",maze,r+1,c+1);

        // Backtrack: unmark the cell before returning
        maze[r][c] = true;

    }
    static int countPath(String path, boolean[][] maze, int r, int c) {
        // Base condition: reached the bottom-right cell
        if(r==maze.length || c==maze[0].length || c<0 || r<0 ){
            return 0;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
            System.out.println();
            return 1;
        }
        // If the current cell is already visited or blocked
        if (!maze[r][c]) {
            return 0;
        }

        // Mark the cell as visited
        maze[r][c] = false;
        // Move Down
        int  x = countPath(path + "(DW)", maze, r + 1, c);

        // Move Right
        int y = countPath(path + "(RG)", maze, r, c + 1);

        // Move Up
        int z = countPath(path + "(UP)", maze, r - 1, c);

        // Move Left
        int s =  countPath(path + "(LF)", maze, r, c - 1);

        int p = countPath(path+"(DG)",maze,r+1,c+1);

        // Backtrack: unmark the cell before returning
        maze[r][c] = true;
        return x+y+z+s+p;

    }

    //This code is alternate version of count path MazeAllDirection
    //In this we are traversing Diagonal also
}
