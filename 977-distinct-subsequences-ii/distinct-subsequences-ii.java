class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length(); 

        long dp = 0; //no subsequence
        long []last = new long[26];

        for(char ch : s.toCharArray()){
            int index = ch -'a';

            long old_dp = dp;

            dp = (2 * dp + 1 - last[index] + mod) % mod;
            last[index]=old_dp + 1;
        }

        return (int)dp;
    }
}