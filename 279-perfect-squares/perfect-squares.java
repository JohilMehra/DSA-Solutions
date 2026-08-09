class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return find(n,dp);
    }

    //memoization
    int find(int n,int[] dp){
        //base case
        if(n == 0){
            return 0;
        }

        // if already computed
        if(dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int j = 1;j*j<=n;j++){
            int sq = j*j;

            ans = Math.min(ans,1+find(n-sq,dp));
        }

        return dp[n] = ans;
    }
}