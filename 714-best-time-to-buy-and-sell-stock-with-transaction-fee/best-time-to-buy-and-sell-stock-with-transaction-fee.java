class Solution {
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp=new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(0,n,1,prices,fee);
    }
    int solve(int i,int n,int buy,int[] prices,int fee){
        if(i == n) return 0;
        
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1){
            int Buy = -prices[i] + solve(i+1,n,0,prices,fee);
            int notBuy = solve(i+1,n,1,prices,fee);
            return dp[i][buy] = Math.max(Buy,notBuy);
        }else{
            int sell = (prices[i]-fee) + solve(i+1,n,1,prices,fee);
            int notSell = solve(i+1,n,0,prices,fee);
            return dp[i][buy] = Math.max(sell,notSell);
        }
    }
}