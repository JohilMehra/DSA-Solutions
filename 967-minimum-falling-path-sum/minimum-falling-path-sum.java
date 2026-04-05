class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int [][]dir={{-1,-1},{-1,0},{-1,1}};
        int n=matrix.length , m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int min=Integer.MAX_VALUE;
                for(int d[]:dir){
                    int x=i+d[0];
                    int y=j+d[1];
                    if(x>=0 && y>=0 && x<n && y<m){
                        min=Math.min(min,matrix[i][j]+dp[x][y]);
                    }
                }
                dp[i][j]=min;
            }
        }
        int min=Integer.MAX_VALUE;
        int i=n-1;
        for(int j=0;j<m;j++){
            min=Math.min(min,dp[i][j]);
        }
        return min;
    }
}