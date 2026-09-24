class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 10 && nums[i] == i){
                return i;
            }else{
                int num = nums[i];
                int sum = 0;
                while(num > 0){
                    int digit = num%10;
                    sum += digit;
                    num /= 10;
                }

                if(sum == i){
                    return i;
                }
            }
        }

        return -1;
    }
}