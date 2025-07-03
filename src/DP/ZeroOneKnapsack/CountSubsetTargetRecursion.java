package DP.ZeroOneKnapsack;
class CountSubsetTargetRecursion{
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        int target = 12;
        int n = arr.length;

        System.out.println("The no of subset present in the array which add up to target is "+ countSubset(arr,target,n));
    }
    public static int countSubset(int[] arr,int target,int n){
        if(target==0){
            return 1;
        }if(n==0){
            return 0;
        }
        if(arr[n-1]<=target){
            int include = countSubset(arr,target-arr[n-1],n-1);
            int exclude = countSubset(arr,target,n-1);
            return include+exclude;
        }
        return countSubset(arr,target,n-1);
    }

}