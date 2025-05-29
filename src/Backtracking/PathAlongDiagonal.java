package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathAlongDiagonal{
    public static void main(String[] args) {
        //Now the idea is that we can also go diagonay not just down and right
        System.out.println(printPath("",2,2));
        System.out.println("The total no of path including diagonal one is " + countPath(2,2));

    }
    static List<String> printPath(String p, int i, int j){
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

        list.addAll(printPath(p+"(dw)",i-1,j));
        list.addAll( printPath(p+"(rg)",i,j-1));
        list.addAll(printPath(p+"(dg)",i-1,j-1));

        return list;

    }
    static int countPath(int i,int j){
        if(i<1 || j<1){
            return 0;
        }
        if(i==1 && j==1){
            return 1;
        }
        int k = countPath(i-1,j);
        int l = countPath(i,j-1);
        int m = countPath(i-1,j-1);

        return k+l+m;
    }

}