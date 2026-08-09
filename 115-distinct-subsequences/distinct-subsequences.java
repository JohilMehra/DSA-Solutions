class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int [][]dp = new int[n][m];
        for(int []row : dp) Arrays.fill(row,-1);

        return find(n-1,m-1,s,t,dp);
    }

    //memoization method
    int find(int i,int j,String s,String t,int [][]dp){
        //base cases
        //1. j<0 means all char of t found -> return +1
        if(j < 0) return 1;
        //2. i<0 but j>0 means not found the substring matchs t string
        if(i < 0) return 0;

        //if already computed
        if(dp[i][j] != -1) return dp[i][j];

        //if matches -> take and notake(go for other char matches)
        if(s.charAt(i) == t.charAt(j)){
            int take = find(i-1,j-1,s,t,dp);
            int notake = find(i-1,j,s,t,dp);

            return dp[i][j] = take + notake;
            
        }else{
            //if not matches -> don't take
            return dp[i][j] = find(i-1,j,s,t,dp);
        }
    }
}