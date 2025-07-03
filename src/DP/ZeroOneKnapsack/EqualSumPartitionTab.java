package DP.ZeroOneKnapsack;
class EqualSumPartitionTab{
    public static void main(String[] args) {
        //We are writint the most effficient code for equal sum partitioning .
        //Here, We go baby.
        int[] arr = {1,5,11,5};
        int total = 0;
        for(int num:arr){
            total+=num;
        }
        if(total%2!=0){
            System.out.println("The given array cannot be partioned ");
        }
    }
}