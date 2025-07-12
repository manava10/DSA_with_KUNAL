package DP.MCM;
class EvaluateExpression{
    public static void main(String[] args) {
        String exp = "T^F|F";
        int n = exp.length();
        int result = result(exp,0,n-1,true);
        System.out.println("The no of ways of putting bracket is :"+ result);
    }
    static int result(String exp,int i, int j,boolean isTrue){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue){
                return exp.charAt(i)=='T'?1:0;
            }else{
                return exp.charAt(i)=='F'?1:0;
            }
        }
        int ways = 0;
        for (int k = i+1; k<j; k+=2){
            char operator = exp.charAt(k);

            int lt = result(exp,i,k-1,true);
            int lf = result(exp,i,k-1,false);
            int rt = result(exp,k+1,j,true);
            int rf = result(exp,k+1,j,false);

            if(operator == '&'){
                if(isTrue){
                    ways+= lt*rt;
                }else{
                    ways += lf*rf + lf*rt + rf*lt;
                }
            }else if(operator=='|'){
                if(isTrue){
                    ways+= lt*rf + lf*rt + rt*lt;
                }else{
                    ways+= lf*rf;
                }
            }else if(operator == '^'){
                if(isTrue){
                    ways+= lt*rf + rt*lf;
                }else{
                    ways+= lf*rf + lt*rt;
                }
            }

        }
        return ways;
    }
}
//Yes getting it correct .