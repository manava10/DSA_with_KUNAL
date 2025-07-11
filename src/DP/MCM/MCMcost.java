
package DP.MCM;
public class MCMcost{
    public static void main(String[] args) {
        // We have given an array , and we have to find the mcm cost \
        int[] given = {10,20,30};
        int length = given.length;
        int i = 1;
        int j = length-1;
        int result = solve(given,i,j);
        System.out.println("The optimal cost of multiplying the given matrix is: "+ result);
    }
    static int solve(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = solve(arr,i,k);
            int cost2 = solve(arr,k+1,j);
            int finalCost = cost1 + cost2 + arr[i-1]*arr[k]*arr[j];
            minCost = Math.min(minCost,finalCost);
        }
        return minCost;
    }
}
