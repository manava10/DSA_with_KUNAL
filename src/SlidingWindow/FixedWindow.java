package SlidingWindow;

import java.util.jar.JarEntry;

class FixedWindow{
    public static void main(String[] args) {
        int[] given = {-1,2,3,3,4,5,-1};
        int n = given.length;
        int k = 4;
        //We have to find the maximum sum we can pickup by picking 4 elements// that should be subarray.
        int maxSum = Integer.MIN_VALUE;
        //First of all find the sum of first four element right,
        int localSum = 0;
        for(int i=0;i<k;i++){
            localSum += given[i];
        }
        maxSum = localSum;
        int left = 0;
        int right = k;
        while(right<n){
            localSum -= given[left];
            left++;
            localSum += given[right];
            maxSum = Math.max(localSum,maxSum);
            right++;
        }
        System.out.println(maxSum);
    }
}