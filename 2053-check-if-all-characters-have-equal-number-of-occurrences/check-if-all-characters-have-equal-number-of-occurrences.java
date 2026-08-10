class Solution {
    public boolean areOccurrencesEqual(String s) {
        int []freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        
        //target freq
        int targetfreq = freq[s.charAt(0)-'a'];

        for(int count : freq){
            if(count != 0 && count != targetfreq){
                return false;
            }
        }

        return true;
    }
}