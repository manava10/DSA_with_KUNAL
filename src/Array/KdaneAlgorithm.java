package Array;
class KdaneAlgorith{
    public static void main(String[] args) {
        int[] arr = {1,-1,2,3,5};
        //We have to find the maximum sum of subarray.
        int start = 0; int ansStart=0; int ansEnd=0;
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0; //So, the localMax is zero rightly
        int i=0;
        for(int num:arr){
            if(localMax<0){
                localMax = num;
                start = i;

            }else{
                localMax+= num;
            }

            if(localMax>globalMax){
                globalMax=localMax;
                ansStart = start;
                ansEnd = i;
            }
            i++;
        }
        System.out.println(globalMax);
        for(int j=ansStart;j<=ansEnd;j++){
            System.out.println(arr[j]);
        }

    }
    //Now we will expand this code for the printig of subarray. okay
}
//Chaliye debugg karte hai,maza aaegea.