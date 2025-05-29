package String;
public class skipChar{
    public static void main(String[] args){
        String a = "aabbccddaba";
        
        //Actually we have to make a new string using given string by skiping a char
        skip("",a);
        


    }
    static void skip(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch=='a'){
            skip(p, up.substring(1));
        }else{
            skip(p+ch, up.substring(1));
        }
    }
}