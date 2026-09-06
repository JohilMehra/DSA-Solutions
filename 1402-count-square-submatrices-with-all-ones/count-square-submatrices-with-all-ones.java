class Solution {
    //same approach as leetcode 221 (maximal square)
    public int countSquares(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;

        int dp[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 1){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                }
            }
        }

        //For each (i,j), stores:
        //"How many new squares can I make whose bottom-right corner is this current cell (i,j)?
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                count += dp[i][j];
            }
        }

        return count;
    }
}