class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int [] ans= new int[code.length];

        Arrays.fill(ans,0);

        if(k==0) return ans;

        if(k>0){
            for(int i=0;i<code.length;i++){
                for(int j=i+1;j<=i+k;j++){
                    ans[i]+=code[j%code.length];
                }
            }
        }
        if(k<0){
            for(int i=0;i<code.length;i++){
                for(int j=i-1;j>=i+k;j--){
                    ans[i]+=code[(j+code.length)%code.length];
                }
            }
        }



        return ans;


    }
}