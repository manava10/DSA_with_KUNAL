package DP.String;
class LcsRecursion{
    public static void main(String[] args) {
        String s = "abcde";
        String p = "abedfhg";
        int k = 0;
        int r = 0;


        System.out.println("the length of lcs of given two string is "+lcsLength(s,p,k,r));


    }
    public static int lcsLength(String s,String p,int k, int r){
        if(k==s.length()||r==p.length()){
            return 0;
        }if(s.charAt(k)==p.charAt(r)){

            return 1+lcsLength(s,p,k+1,r+1);
        }
        return Math.max(lcsLength(s,p,k+1,r),lcsLength(s,p,k,r+1));
    }

}
