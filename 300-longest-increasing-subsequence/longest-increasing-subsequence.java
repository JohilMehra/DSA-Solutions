class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max=1;

        for(int i=1;i<n;i++){
            int currmax=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    currmax=Math.max(currmax,dp[j]+1);
                }
            }
            dp[i]=currmax;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}