class Solution {
    Boolean [][]dp; //object stores null by default

    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length(), n2=s2.length(), n3=s3.length();

        if(n1 + n2 != n3){
            //not possible to make s3 using s1 and s2
            return false;
        }
        dp = new Boolean[n1][n2];
        return find(n1-1,n2-1,n3-1,s1,s2,s3);
    }

    boolean find(int i,int j,int k,String s1,String s2,String s3){
        // Both s1 and s2 are completely consumed
        if (i < 0 && j < 0) {
            return true;
        }

        if(i>=0 && j>=0 && dp[i][j] != null){
            return dp[i][j];
        }

        boolean takeS1 = false; //from s1
        boolean takeS2 = false; //from s2
        
        if(i>=0 && s1.charAt(i) == s3.charAt(k)){
            //if s1 char matches with s3 char
            takeS1 = find(i-1,j,k-1,s1,s2,s3);
        }
        if(j>=0 && s2.charAt(j) == s3.charAt(k)){
            //if s2 char matches with s3 char
            takeS2 = find(i,j-1,k-1,s1,s2,s3);
        }

        //stores true if matches with either s1 or s2 , otherwise false
        boolean ans = takeS1 || takeS2;
        if(i>=0 && j>=0){
            dp[i][j] = ans;
        }
        return ans;
    }
}