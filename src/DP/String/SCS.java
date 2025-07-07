package DP.String;
class SCS{
    public static void main(String[] args) {
        String a = "asdfgeg";String b = "asgedge";
        //We need to find the length of SCS,
        int lcsLength = LcsTabulation.lcsLength(a,b);
        // We are using method of other class to calculate the lcs length , as it will increase code re usability
        int scsLength = a.length()+b.length()-lcsLength;
        System.out.println("The length of Shortest Common Supersubsequnces of the given two string is :"+scsLength);
    }
}