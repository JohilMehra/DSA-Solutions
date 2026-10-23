class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int ans = -1;
        for(int i = 0; i < n; i++){
            if(i != nums[i]){
                ans = ans & nums[i];
            }
        }
        return Math.max(ans,0);
    }
}