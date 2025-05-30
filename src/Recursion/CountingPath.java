package Recursion;
public class CountingPath {
    public static void main(String[] args) {
        //We are counting path of a given Maze
        //We are at 0,0 we have to ra
        int m = 3;
        int n = 3;
        //Initially we are at 0,0 in a matrix of 3*3
        System.out.println(countPath(0,0));
    }
    static int countPath(int i,int j){
        if((i==2) || (j==2)){
            return 1;
        }
        int noOfLeftPath = countPath(i+1,j);
        int noOfRightPath = countPath(i,j+1);

        return noOfLeftPath+noOfRightPath;
    }
}