package DP.ZeroOneKnapsack;
class MinimumSubsetSumDiffTab{
    public static void main(String[] args) {
        //
        int[] arr = {1, 6, 11, 5}; //Have to apply dynamic programming  to find the min.
        int totalSum = 0;
        for(int num:arr){
            totalSum += num;
        }
        int n = arr.length;
        // We have to divide out array in two subset that difference of sum of element in them is minimal .
        // we are finding the total sum , let s1 be first subset and s2 be second, so s1, s2 lies between 0 to totalsum inclusive ,
        // have to find Min(s2-s1)s2>s1,(out assumption), s1+s2=totalSum, => Min(totalSum-2S1). We are assuming , s1<=S2.
        Boolean[][] dp = new Boolean[n+1][totalSum+1];
        //Writing dp to check at which integer form 0 to total Sum, sum of subset of that array can be found .
        for(int i=0;i<=totalSum;i++){
            dp[0][i] = false;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=totalSum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        } // We have successfully made the dynamic Programming table, Now we need the get the last row of dp.
        int MinDiff = Integer.MAX_VALUE;
        for(int i=0;i<=(totalSum)/2;i++){
            if(dp[n][i]){
                MinDiff = Math.min(MinDiff,totalSum-2*i);

            }
        }
        System.out.println("The Minimum Subset sum difference is :"+MinDiff);
    }
    //This is correct and fully functional code for minimum subset sum difference

}
//Main Logic Breakdown (Revision Notes)
/*
	1.	Calculate Total Sum
	•	You first compute the total sum of all elements in the array. This total is used to determine the possible range of subset sums.
        2.	Problem Transformation
	•	You realize that splitting the array into two subsets S1 and S2 such that the difference |S1 - S2| is minimized is equivalent to minimizing |totalSum - 2*S1|, assuming S1 ≤ S2.
	3.	DP Table Setup
	•	You use a 2D DP table (dp[n+1][totalSum+1]) to record whether a particular sum is achievable with the first i elements of the array.
        4.	Base Case Initialization
	•	You initialize the table by marking:
        •	All dp[i][0] as true because a sum of 0 is always possible.
	•	All dp[0][j] (for j > 0) as false because you can’t make any non-zero sum with 0 elements.
	5.	Tabulation Logic
	•	You fill the DP table using the standard 0/1 Knapsack inclusion-exclusion logic:
        •	If the current element is greater than the current sum, you exclude it.
        •	Otherwise, you check if the sum can be achieved either by including or excluding the current element.
	6.	Finding the Closest Subset Sum
	•	After filling the DP table, you look through the last row (which represents using all n elements) to find the largest sum S1 ≤ totalSum/2 that is achievable.
	7.	Calculating Minimum Difference
	•	For each valid subset sum S1, you compute totalSum - 2*S1 and track the minimum value among them. This represents the minimum subset sum difference.
	8.	Final Output
	•	You print the minimum difference, which is the optimal result for partitioning the array into two subsets with minimal sum difference.

 */
