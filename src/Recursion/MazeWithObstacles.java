package Recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacles{
    public static void main(String[] args) {
        //Actually we have to find way of going from inital to final in a maze
        //There are some defined obstacle.
        // So, in a 3*3 matrix of index 0, we are at 3,3  , we wanna reach 1,1
        System.out.println(printPath("",4,4,2,2));
    }
    static List<String> printPath(String p,int i,int j,int k,int l){
        //(k,l) is nothing but the obstacle, we cannot go .
        List<String> list = new ArrayList<>();
        if(i<1 || j<1){
            return list;
        }
        if(i==k && j==l){
            list.add(p);
            return list; // Return as we encountered Obstacle.
        }
        if(i==1 && k==1){
            list.add(p);
        }
        list.addAll(printPath(p+"d",i-1,j,k,l));
        list.addAll(printPath(p+"r",i,j-1,k,l));

        return  list;

    }

}