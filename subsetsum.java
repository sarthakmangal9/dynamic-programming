package dp;
// remember it will only work for positive subsets
public class subsetsum {
    public static boolean sum(int i,int target,int [] arr,int [][] dp){
        if(i==arr.length) {

            if (target == 0)
                return true;
            else return false;
        }
        if(dp[i][target]!=-1)
            return (dp[i][target]==1);
        boolean ans =false;
       boolean skip=sum(i+1,target,arr,dp);
       if(target-arr[i]<0)
           ans =skip;
else {
           boolean pick = sum(i + 1, target - arr[i], arr, dp);
           ans= pick || skip;
       }
if(ans) dp[i][target]=1;
else dp[i][target]=0;
return ans;

    }
    public static void main() {
        int [] arr={3,6,7,2,1};
        int target=19;
        int [][] dp=new int[arr.length][target+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<target+1;j++){
                dp[i][j]=-1;
            }
        }
        boolean s=sum(0,target,arr,dp);
        System.out.println(s);

    }
}
// time complexity 2^n
