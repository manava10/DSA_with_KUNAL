package SlidingWindow;
class LongestSubArray{
    public static void main(String[] args) {
        //We have given a subarray
        int[] given = {2,5,1,7,10};
        int maxValue = 14;
        int left = 0;
        int localSum = 0;
        int maxWindowSize = 0;
        for(int right =0;right<given.length;right++){
            localSum+= given[right];
            if(localSum<=maxValue){
                maxWindowSize = Math.max(maxWindowSize,right-left+1);
            }else{
                while(localSum>maxValue){
                    localSum -= given[left];
                    left++;
                }

            }
        }
        System.out.println(maxWindowSize);
    }
}