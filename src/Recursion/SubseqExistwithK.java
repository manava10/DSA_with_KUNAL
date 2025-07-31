package Recursion;
class SubseqExistwithK{
    public static void main(String[] args) {
        //We will be given a array and have to find if any subsew of the array has sum K
        int[] arr = {1,3,5,6,7};
        int target = 18;
        System.out.println("subseq Exist with sum K :"+exist(arr,target,arr.length-1));
    }
    static boolean exist(int[] arr,int target, int i){
        if(target==0){
            return true;
        }
        if(i<0){
            return false;
        }
        return exist(arr,target-arr[i],i-1) || exist(arr,target,i-1);//this code is enough i guess
    }

}