class Solution {
    int dp[][];
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return find(0,n-1,values);
    }

    public int find(int l,int r,int[] values){
        // Less than 3 vertices , triangle needs 3 vertices
        if(r - l < 2){
            return 0;
        }

        //if already computed
        if(dp[l][r] != -1) return dp[l][r];

        int ans = Integer.MAX_VALUE;
        //possible all between edges
        for(int k = l+1; k<r; k++){
            int cost = find(l,k,values)
                        + values[l] * values[k] * values[r]
                        + find(k,r,values);

            ans = Math.min(ans,cost);
        }
        return dp[l][r] = ans;
    }
}