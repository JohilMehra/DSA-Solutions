class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;

        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int time=0;

        while(!q.isEmpty() && fresh>0){
            time++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int r=curr[0];
                int c=curr[1];

                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return fresh==0?time:-1;
    }
}