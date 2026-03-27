class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        //s,length==0 && p.length==0
        dp[0][0]=true;
        //s.length>0 && p.length==0
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        //s.length==0 && p.length>0
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)=='*'){ 
                dp[0][j]=dp[0][j-1]; //depends on previous 
            }
            //otherwise false if p.charAt==? or any char
        }

        //bottom up 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    //either match and not remove(*) or ignore(match with ' ' string) 
                    dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j]=false; //charater doesn't match with pattern
                }
            }
        }
        return dp[n][m];
    }
}