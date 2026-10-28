class Solution {

    int grid[][];
    int m,n;
    Integer [][][]dp;

    public int minCost(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m][1024];

        return solve(0,0,grid[0][0]);
    }

    int solve(int i,int j,int xorsofar){
        //edge base
        if(i == n-1 && j == m-1){
            return xorsofar;
        }

        //already calculated
        if(dp[i][j][xorsofar] != null){
            return dp[i][j][xorsofar];
        }

        int ans = Integer.MAX_VALUE;
        //go up and down and update the path cost till now

        if(j+1 < m){
            //go right
            ans = Math.min(ans, solve(i,j+1,xorsofar ^ grid[i][j+1]));
        }

        if(i+1 < n){
            //go down 
            ans = Math.min(ans, solve(i+1,j,xorsofar ^ grid[i+1][j]));
        }

        return dp[i][j][xorsofar] = ans;
    }
}