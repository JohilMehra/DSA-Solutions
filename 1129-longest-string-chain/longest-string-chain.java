class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(),b.length()));
        int n = words.length;

        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int max = 1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                //words[i].length() > words[j].length()
                if(checkPossible(words[i],words[j]) && dp[j]+1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    //helper function
    boolean checkPossible(String s1, String s2){
        //s1.length() should be = to s2.length()+1
        if(s1.length() != s2.length()+1) return false;

        int first = 0; //pointer at s1
        int second = 0; //pointer at s2
        while(first < s1.length()){
            //s1.char == s2.char
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                //doesn't match, inc first only 
                first++;
            }
        }

        if(first == s1.length() && second == s2.length()){
            //both pointers reaches at last
            return true;
        }
        return false;
    }
}