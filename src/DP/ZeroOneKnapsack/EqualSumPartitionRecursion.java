package DP.ZeroOneKnapsack;
class EqualSumPartitionRecursion{
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int total =0;
        for(int num:arr){
            total+=num;
        }
        if(total%2!=0){
            System.out.println("Cannot be partioned");
        }else{
            boolean result = isEqual(arr,arr.length,total/2);
            System.out.println("The give array is partioned :"+result);
        }
    }
    static boolean isEqual(int[] arr,int n,int target){
        if(target == 0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]<=target){
            return isEqual(arr,n-1,target-arr[n-1]) || isEqual(arr,n-1,target);
        }
        return isEqual(arr,n-1,target);
    }
}
// Now i
// Now i will optimize this without help of any thing .