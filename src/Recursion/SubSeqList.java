package Recursion;

import java.util.ArrayList;

public class SubSeqList {
    public static void main(String[] args){
        SubsetPrint("","abc");
        System.out.println(SubsetPrint("","abcd"));
        System.out.println(subseqAscii("","opqr"));

    }
    static ArrayList<String> SubsetPrint(String p,String up){
        ArrayList<String> temp = new ArrayList<>();
        if(up.isEmpty()){
            temp.add(p);
            return temp;
            // I am creating a new arrayList in everyRecursiveCal
        }
        char a = up.charAt(0);
        String b = up.substring(1);

        ArrayList<String> left = SubsetPrint(p+a,b);
        //As String is immutable, so p+a is new object, we are not changing the original one
        ArrayList<String> right = SubsetPrint(p,b);
        left.addAll(right);

        return left;

    }
    static ArrayList<String> subseqAscii(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        String z = up.substring(1);
        ArrayList<String> first = subseqAscii(p+ch,z);
        ArrayList<String> second = subseqAscii(p,z);
        ArrayList<String> third = subseqAscii(p+(ch+0),z);

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}