class Solution {
    public boolean canPartition(int[] nums) {
        //ques is same like 0/1 knapsack only
        int n=nums.length;
        int sum=0;
        for(int num:nums) sum+=num;

        if(sum%2 != 0) return false;   // we can't divide if sum is odd
        int target=sum/2;

        boolean[][] dp=new boolean[n+1][target+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}