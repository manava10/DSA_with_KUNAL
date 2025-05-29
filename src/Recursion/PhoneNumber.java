package Recursion;
import java.util.List;
import java.util.ArrayList;


class PhoneNumber {
    public static void main(String[] args){
        String digits = "42";
        //Good Morning guys;

        List<String> answer = combination("", digits);
        System.out.println(answer);
    }
    static List<String> combination(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            List<String> baseList = new ArrayList<>();
            baseList.add(processed);
            return baseList;
        }
        List<String> result = new ArrayList<>();
        int digit = unprocessed.charAt(0)-'0';
        if(digit>=2 && digit<=6){
            for(int i=((digit)-2)*3;i<(digit-1)*3;i++){
                char ch = (char) ('a'+i);
                result.addAll(combination(processed+ch,unprocessed.substring(1)));
            }
        }
        if(digit==7){
            for(int i=15;i<19;i++){
                char ch = (char) ('a'+i);
                result.addAll(combination(processed+ch,unprocessed.substring(1)));
            }
        }
        if(digit==8){
            for(int i=19;i<22;i++){
                char ch = (char) ('a'+i);
                result.addAll(combination(processed+ch,unprocessed.substring(1)));
            }
        }
        if(digit==9){
            for(int i=22;i<26;i++){
                char ch = (char) ('a'+i);
                result.addAll(combination(processed+ch,unprocessed.substring(1)));
            }
        }
        return result;
    }
}