class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max[] = new int[n];
        int maxi = nums[0];
        int min[] = new int[n];
        int mini = nums[n-1];

        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,nums[i]);
            max[i] = maxi;
        }

        for(int i=n-1;i>=0;i--){
            mini = Math.min(mini,nums[i]);
            min[i] = mini;
        }

        for(int i=0;i<n;i++){
            if(max[i]-min[i] <= k){
                return i;
            }
        }

        return -1;
    }
}