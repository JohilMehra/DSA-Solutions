class Solution {
    int MOD = 1000000007;
    int m, n;
    int [][]grid;
    Integer dp[][][]; //stores (i,j,dir)
    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length; n = grid[0].length;
        //dir can be 0 (start), 1 (came from up), 2 (came from left)
        dp = new Integer[m][n][3];

        return solve(0,0,0); //(i,j,dir)
    }

    int solve(int i,int j,int dir){
        //base cases
        //out of bound
        if(i >= m || j >= n) return 0;
        //reached case
        if(i == m-1 && j == n-1) return 1;

        if(dp[i][j][dir] != null){
            return dp[i][j][dir];
        }

        long ways = 0;
        if(grid[i][j] == 1){
            //it should be redirect
            if(dir == 1){ //1 -> comes from up,redirect to right
                ways = solve(i,j+1,2);//update dir = 2(left)
            }else if(dir == 2){ //2 -> comes from left, redirect to down
                ways = solve(i+1,j,1); //update dir = 1(up)
            }
        }else{
            //go right and down if it's 0
            long downways = solve(i+1,j,1); //go down
            long rightways = solve(i,j+1,2); //go right
            ways = (downways + rightways) % MOD;
        }

        return dp[i][j][dir] = (int) (ways % MOD);
    }
}