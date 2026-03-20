class Solution {
    static int m,n;
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;

        //1.traverse border and mark safe O as #
        for(int i=0;i<m;i++){
            dfs(board,i,0);  //left border
            dfs(board,i,n-1); //right border
        }

        for(int j=0; j<n; j++){
            dfs(board,0,j); //top border
            dfs(board,m-1,j); //bottom border
        }

        //flip remaining O to X and # to O
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    
    private static void dfs(char[][] board,int i,int j){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!='O'){
            return;
        }
        board[i][j]='#';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}