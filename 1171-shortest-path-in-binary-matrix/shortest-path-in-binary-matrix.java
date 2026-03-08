class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }

        boolean[][] vis=new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();        
        q.offer(new int[]{0,0,1});
        vis[0][0]=true;

        int dir[][]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int dis=curr[2];

            if(r==n-1 && c==n-1){
                return dis;
            }

            for(int[] d: dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if( nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc] && grid[nr][nc]==0){
                    
                    q.offer(new int[]{nr,nc,dis+1});
                    vis[nr][nc]=true;

                }
            }

        }
        return -1;
    }
}