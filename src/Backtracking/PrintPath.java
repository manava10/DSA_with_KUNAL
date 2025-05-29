package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintPath{
    public static void main(String[] args) {
        System.out.println(printPath("",3,3));
        System.out.println();
        printPath1("",3,3);

    }
    static List<String> printPath(String p,int i,int j){
        //This method returning an arrylist , while other is not.
        if(i<1 || j<1){
            List<String> list = new ArrayList<>();
            return list;
        }
        if(i==1 && j==1){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        list.addAll(printPath(p+"d",i-1,j));
        list.addAll( printPath(p+"r",i,j-1));

        return list;

    }
    static void printPath1(String p, int i, int j) {
        if (i < 1 || j < 1) {
            return;
        }
        if (i == 1 && j == 1) {
            System.out.println(p); // Print path when reaching (1,1)
            return;
        }
        printPath1(p + "d", i - 1, j); // Move down
        printPath1(p + "r", i, j - 1); // Move right
    }
}