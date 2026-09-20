class Solution {
    public int reverseDegree(String s) {
        int sum=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int prod = ('z'-ch + 1) * (i+1);
            sum += prod;
        }
        return sum;
    }
}