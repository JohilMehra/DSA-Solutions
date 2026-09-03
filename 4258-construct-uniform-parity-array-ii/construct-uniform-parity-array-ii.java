class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean evenAll = true;
        for(int num : nums){
            if(num % 2 != 0){
                evenAll = false;
                break;
            }
        }

        if(evenAll) return true;

        //if any number 
        for(int i=0;i<n;i++){
            if(nums[i]%2 == 0){
                //it is even, find odd number greater than nums[i]
                //even - odd = odd 
                boolean odd = false;
                for(int j=0;j<i;j++){
                    if(nums[j]<nums[i] && nums[j]%2 != 0){
                        odd=true;
                        break;
                    }
                }
                if(!odd) return false;
            }
        }
        return true;
    }
}