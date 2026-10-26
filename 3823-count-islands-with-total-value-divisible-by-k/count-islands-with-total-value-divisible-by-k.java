class Solution {
    long total = 0;
    boolean vis[][];
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        vis = new boolean[n][m];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] != 0){
                    total = 0;
                    dfs(i,j,grid,n,m);
                    if(total % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    int dir[][] ={{-1,0},{1,0},{0,1},{0,-1}};

    void dfs(int i,int j,int [][]grid,int n,int m){
        total += grid[i][j];
        vis[i][j] = true;

        for(int d[] : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] != 0){
                dfs(nr,nc,grid,n,m);
            }
        }
    }
}