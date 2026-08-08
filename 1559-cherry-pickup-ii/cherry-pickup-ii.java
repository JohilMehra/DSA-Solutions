class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        //this ques uses 3d dp -> dp[i][j1][j2] where (j1 ->robot1) and (j2 -> robot2)
        //i is same for both robots ..we can to move them simultaneously

        int [][][]dp = new int[n][m][m];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }

        return findPath(0,0,m-1,grid,dp,n,m);
    }

    int findPath(int i,int j1,int j2,int[][] grid,int[][][] dp,int n,int m){
        //basecase for out of index
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int) -1e9;
        }
        //return base case : if it reached to the end point
        if(i==n-1){
            //if both j1 and j2 points at same cell then consider only one
            if(j1 == j2){
                return grid[i][j1];
            }else{
                //both at different cell
                return grid[i][j1]+grid[i][j2];
            }
        }

        // If already computed return it
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        // Take chocolates from current cell
        int max = (int)(-1e9);
        int curr = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

        //each robot can move 3 directions , two robot has combination 9
        //outer loop for robot 1 ; (-1,left) ,(0,down), (1,right)
        for(int r1 = -1 ; r1 <= 1 ; r1++){
            //inner loop for robot 2
            for(int r2 = -1 ; r2 <= 1 ; r2++){
                //if both j1 and j2 points at same cell then consider only one
                int ans = curr + findPath(i+1, j1+r1, j2+r2, grid,dp,n,m);

                max = Math.max(max,ans);
            }
        }
        return dp[i][j1][j2] = max;
    }
}