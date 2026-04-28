package dp;

public class knapsacktabulation {
    public static void main() {
        int [] val={2,5,7,4};
        int [] wt={3,4,6,5};
        int cap=8;
        int n=val.length;
        int [][] dp=new int [n][cap+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int skip=(i>0) ?dp[i-1][j]:0;
             if(wt[i]>j) dp[i][j]=skip;
             else{
                int pick=val[i];
                pick+=((i>0)? dp[i-1][j-wt[i]]:0);
                dp[i][j]=Math.max(skip,pick);}
            }
        }

        System.out.println(dp[n-1][cap]);
    }
}
