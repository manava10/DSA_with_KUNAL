package Array;
class LongestSubArrayWithSumK{
    public static void main(String[] args) {
        int []  arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Longest Subarray with sum equal to k.
        int target = 15;
        int longest = 0;
        int left = 0;
        int localSum = 0;
        for(int right=0;right<arr.length;right++){
            localSum += arr[right];
            while(localSum>target){
                localSum = localSum-arr[left];
                left++;
            }
            if(localSum==target){
                longest = Math.max(longest,right-left+1);
            }
        }
        System.out.println(longest);
    }
}