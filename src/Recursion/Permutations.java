package Recursion;
import java.util.*;
public class Permutations{
    public static void main(String[] args) {
       List<String> ans = permutation1("","abcd");
       for(String a : ans){
           System.out.println(a);
           System.out.println();
       }
        System.out.println("The no of permutaion of the given :"+ permutationCount("","abcdfghaqwe"));
    }
    static List<String> permutation1(String p, String up){
        List<String> answer = new ArrayList<>();
        if(up.isEmpty()){
            answer.add(p);
            return answer;

        }
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String s = p.substring(0,i);
            String f = p.substring(i,p.length());
            answer.addAll(permutation1(s+ch+f,up.substring(1)));
        }
        return answer;
    }
    static int  permutationCount(String p, String up){
        List<String> answer = new ArrayList<>();
        if(up.isEmpty()){

            return 1;

        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String s = p.substring(0,i);
            String f = p.substring(i,p.length());
            count = count + (permutationCount(s+ch+f,up.substring(1)));
        }
        return count;
    }
}
//This is code for Permuataions.