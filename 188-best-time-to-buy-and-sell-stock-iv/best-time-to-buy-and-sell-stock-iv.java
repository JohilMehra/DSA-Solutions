class Solution {
    int dp[][][];
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp= new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<=k;l++){
                    dp[i][j][l]=-1;
                }
            }
        }
        return solve(0,n,1,k,prices);
    }

    int solve(int i,int n,int buy,int k,int[] prices){
        if(k == 0) return 0;
        if(i == n) return 0;
        
        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        if(buy == 1){
            int Buy = -prices[i] + solve(i+1,n,0,k,prices);
            int notBuy = solve(i+1,n,1,k,prices);
            return dp[i][buy][k] = Math.max(Buy,notBuy);
        }else{
            int sell = prices[i] + solve(i+1,n,1,k-1,prices);
            int notSell = solve(i+1,n,0,k,prices);
            return dp[i][buy][k] = Math.max(sell,notSell);
        }
    }
}