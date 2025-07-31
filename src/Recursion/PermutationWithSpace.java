package Recursion;
class PermutationWithSpace{
    public static void main(String[] args) {
        String input = "ABCD";
        String output = input.substring(0,1);
        printPer(input.substring(1),output);
    }
    static void printPer(String input,String output){
        if(input.isEmpty()){
            System.out.println(output);
            System.out.println(output.length());
            return;
        }
        char a = input.charAt(0);
        printPer(input.substring(1),output+" "+a);
        printPer(input.substring(1),output+a);


    }
}