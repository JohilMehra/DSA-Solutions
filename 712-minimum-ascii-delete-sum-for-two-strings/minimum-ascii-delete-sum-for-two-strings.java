class Solution {
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        dp = new int[n][m];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1, m-1, s1, s2);
    }

    int solve(int i, int j,String s1, String s2){
        //Base case: both strings are fully processed
        if(i<0 && j<0){
            return 0;
        }
        // If s1 is exhausted, we must delete all remaining characters in s2
        if(i<0){
            int sum=0;
            while(j >= 0){
                sum += s2.charAt(j);
                j--;
            }
            return sum;
        }
        // If s2 is exhausted, we must delete all remaining characters in s1
        if(j<0){
            int sum=0;
            while(i >= 0){
                sum += s1.charAt(i);
                i--;
            }
            return sum;
        }

        //if already calculated
        if(dp[i][j] != -1) return dp[i][j];

        // If characters match, no deletion needed here; move both pointers
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i-1,j-1,s1,s2);
        }else{
            //option:1 delete char from s1
            int deleteS1 = s1.charAt(i) + solve(i-1,j,s1,s2);
            //option:2 de;ete char from s2
            int deleteS2 = s2.charAt(j) + solve(i,j-1,s1,s2);

            return dp[i][j] = Math.min(deleteS1, deleteS2);
        }
    }
}