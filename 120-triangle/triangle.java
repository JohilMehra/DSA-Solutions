class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }

        return findMin(0,0,triangle,dp,n);        
    }

    int findMin(int i,int j,List<List<Integer>> triangle,int dp[][],int n){
        //base case
        //if we reach at end state
        if(i==n-1) return triangle.get(i).get(j);

        //already calculated - remove overlapping
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int nextS = findMin(i+1,j,triangle,dp,n);
        int nextDS = findMin(i+1,j+1,triangle,dp,n);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(nextS,nextDS);
    }
}