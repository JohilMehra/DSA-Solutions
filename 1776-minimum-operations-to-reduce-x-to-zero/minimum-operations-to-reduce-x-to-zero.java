class Solution {
    //we will find the largest subarray of totalsum - x
    //that gives us the minimum operations to make x
    public int minOperations(int[] nums, int x) {
        int n = nums.length;        
        int totalsum = 0;
        for(int num : nums) totalsum += num;

        int target = totalsum - x;

        int sum = 0;
        int left = 0;
        int maxLen = -1;

        for(int right = 0; right < n; right++){
            sum += nums[right];

            while(sum > target && left <= right){
                sum -= nums[left];
                left++;
            }

            if(sum == target){
                maxLen = Math.max(maxLen,right-left+1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}