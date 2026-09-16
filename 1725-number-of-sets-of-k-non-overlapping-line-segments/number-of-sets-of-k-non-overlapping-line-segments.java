class Solution {
    int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        long dp[][] = new long[n][k+1];

        for(int i=0;i<n;i++){
            dp[i][0]=1; //if k == 0 
        }

        for(int j=1;j<=k;j++){
            long sum = 0; //all the ways of making j-1 segments using every possible point before i.
            for(int i=1;i<n;i++){

                //take
                //create a new segment ending at i
                sum = (sum + dp[i-1][j-1]) % MOD;
                long take = sum;

                //skip : not use point i as the new segment
                long notTake = dp[i-1][j];

                dp[i][j] = (take + notTake) % MOD;

            }
        }
        return (int)dp[n-1][k];
    }
}