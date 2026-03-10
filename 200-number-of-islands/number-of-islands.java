class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid,i,j,vis,m,n);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void dfs(char[][] graph,int u,int v,boolean[][] vis,int m,int n){
        vis[u][v]=true;
        
        int r=u;
        int c=v;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !vis[nr][nc] && graph[nr][nc]=='1'){
                dfs(graph,nr,nc,vis,m,n);
            }
        }
    }
}