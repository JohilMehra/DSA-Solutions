class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        } 
        Arrays.sort(nums);
        long score=0;
        int left=0;
        int right=nums.length-1;
        while(left<right){
            long diff = (long) nums[right] * nums[right] - (long) nums[left] * nums[left];
            score+=diff;
            right--;
            left++;
        }
        if((nums.length)%2!=0){
            score+=(long)nums[left]*nums[left];
        }
        return score;
    }
}