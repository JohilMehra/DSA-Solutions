class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,n,1,2,prices);//(i,n,(1=can buy ,0=can't buy),at most 2,prices)
    }

    int solve(int i,int n,int buy,int cap,int []prices){
        if(cap == 0) return 0; //if two transaction is done
        if(i == n) return 0;

        //if already calculated
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        if(buy == 1){ //buy==1 means: allow to buy
            int Buy = -prices[i] + solve(i+1,n,0,cap,prices);
            int notBuy = solve(i+1,n,1,cap,prices);
            return dp[i][buy][cap] = Math.max(Buy, notBuy);
        }else{
            //sell
            int sell = prices[i] + solve(i+1,n,1,cap-1,prices);
            int notSell = solve(i+1,n,0,cap,prices);
            return dp[i][buy][cap] = Math.max(sell,notSell);
        }
    }
}