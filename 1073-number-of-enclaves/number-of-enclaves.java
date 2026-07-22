class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][]vis = new boolean[n][m];

        //moves boundaries & mark the island visited if touchs with boundary means boundary having 1

        // left & right boundary
        for(int i=0;i<n;i++){
            //left
            if(vis[i][0] == false && grid[i][0]==1){
                dfs(i,0,vis,grid);
            }
            //right
            if(vis[i][m-1]==false && grid[i][m-1]==1){
                dfs(i,m-1,vis,grid);
            }
        }
        //top & bottom boundary
        for(int j=0;j<m;j++){
            if(vis[0][j]==false && grid[0][j]==1){
                dfs(0,j,vis,grid);
            }
            if(vis[n-1][j]==false && grid[n-1][j]==1){
                dfs(n-1,j,vis,grid);
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int r,int c,boolean[][]vis,int [][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int [][]dir={{0,1},{0,-1},{1,0},{-1,0}};

        vis[r][c]=true;

        for(int []d : dir){
            int nr=r+d[0];
            int nc=c+d[1];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr,nc,vis,grid);
            }
        }
    }
}