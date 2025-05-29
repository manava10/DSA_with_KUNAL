package Recursion;

public class Subseq {
    public static void main(String[] args){
        SubsetPrint("","abc");
    }
    static void SubsetPrint(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            System.out.println(  );
            return;
        }
        char a = up.charAt(0);

        SubsetPrint(p+a,up.substring(1));
        SubsetPrint(p,up.substring(1));

    }

}