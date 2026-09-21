class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int val = num % k;

            // 1. Start a new subarray with only nums[i]
            newDp[val]++;

            // 2. Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {
                    int newRemainder = (r * val) % k;
                    newDp[newRemainder] += dp[r];
                }
            }

            // 3. Add all subarrays ending here to the final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            // 4. Move to the next index
            dp = newDp;
        }

        return ans;
    }
}