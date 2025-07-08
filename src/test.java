class test {
    public static void main(String[] args) {
        int[] g = {7,8,9,10};
        int[] s = {5,6,7,8};
        System.out.println("Try programiz.pro " +  len(g,s));
    }
    static int len(int[] g,int[] s){
        int i =0;int j=0;
        int content = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[i]){
                content = content+1;
                i++; j++;
            }else{
                j++;
            }
        }
        return content;
    }
}