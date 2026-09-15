class Solution {
    int dp[]; //tells max number palindromes we can choose if starts from i.
    boolean pal[][];
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);

        pal=new boolean[n][n];

        //pre-calculate palindrome for all combinations to optimize
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){ //same
                    //if len is less then 3
                    if(j-i <= 2){
                        pal[i][j]=true;
                    }
                    else if(pal[i+1][j-1]){
                        pal[i][j] = true;
                    }
                }
            }
        }
        return findPalindromes(0,k,s);
    }

    int findPalindromes(int i,int k,String s){
        if(i >= s.length()){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        //don't start from here, skip curr ele
        int notTake = findPalindromes(i+1,k,s);
        //start from curr i
        int takemax = 0;
        for(int j=i+k-1;j<s.length();j++){
            if(pal[i][j]){
                int take = 1+ findPalindromes(j+1,k,s);
                takemax = Math.max(takemax,take);
            }
        }
        return dp[i] = Math.max(notTake,takemax);
    }
}