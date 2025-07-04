package ZeroOneKnapsack;
class CountSubSetjavaRecursion{
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,8};
        int target = 5;
        int  n = arr.length;
        System.out.println("The  no of ways of SubsetSum is "+ways(arr, target,n));

    }
    public static int ways(int[] arr,int target,int n){
        if(target == 0){
            return 1;
        }
        if(n==0){
            return 0;
        }

        if(arr[n-1]<=target){
            int a = ways(arr,target-arr[n-1],n-1); //include
            int b = ways(arr,target,n-1); //Exclude
            return a+b;
        }
        return ways(arr,target,n-1);
    }
    //This is the recursive code for count subset  with sum L.
}