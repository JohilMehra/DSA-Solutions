class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                    mat[nr][nc]=mat[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}