class Solution {
    public String maxSumOfSquares(int num, int sum) {
        //number represent ans length
        if(sum > num * 9) return "";

        StringBuilder ans = new StringBuilder();
        int rem = sum;

        //we need n such digits to make sum of that digits == sum
        for(int i=0;i<num;i++){
            int digit = Math.min(9,rem); //max we can use 9 at every point
            ans.append(digit);
            rem -= digit;
        }
        return ans.toString();
    }
}