package Array;
class LongestSubarrayWithGivenSumK{
    public static void main(String[] args){
        int[] arr = {2,3,5,6,2,1,1,1};
        //We have to find the longes subarray haveing sum as K.
        int MaxLength = 0;
        int target = 20;
        int localSum = 0;
        int left =0;
        for(int right=0;right<arr.length;right++){
             localSum  += arr[right];
             while(localSum>target){
                 localSum -= arr[left];
                 left++;
             }
             if(localSum==target){
                 MaxLength = Math.max(MaxLength,right-left+1);
             }
        }
        System.out.println(MaxLength);
    }
}
//This is the maxLength of the subarray we are requiring.