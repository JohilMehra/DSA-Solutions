class Solution {
    //Four options for the solutions are:
    /* 1. if forward ordering is correct -- ascending order
            1.1 rotate left zero times. cost = zero
            1.2 reverse -> rotate left n-zero times -> reverse. cost = n-zero+2
       2. if backkward ordering is correct -- ascending order
            2.1 rotate left zero+1 times, that takes zero at n-1 , 
                then reverse.  cost = zero+1+1 == zero+2
            2.2 reverse -> rotate left n-1-zero times. 
                cost = n-zero-1+1(reverse) == n-zero
    */ 
    public int minOperations(int[] nums) {
        int n = nums.length;

        int zero = 0;
        //find position of 0 in the array
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                zero = i;
                break;
            }
        }

        boolean forward = true;
        boolean backward = true;

        for(int i = 0; i < n; i++){
            //moving pointer to right direction from zero pointer
            int right = (zero + i) % n;
            //moving pointer to left direction from zero pointer
            int left = (zero - i + n) % n;

            if(nums[right] != i){
                forward = false; //no forward ordering
            }

            if(nums[left] != i){
                backward = false; //no backward ordering
            }
        }

        int ans = Integer.MAX_VALUE;

        // Case 1: Forward circular order is valid
        if(forward){
            //find the min of two options
            //option 1
            ans = Math.min(ans,zero);
            //option 2
            ans = Math.min(ans,n-zero+2);
        }

        // Case 2: Backward order is valid
        if(backward){
            //two options
            ans = Math.min(ans,zero+2);
            ans = Math.min(ans,n-1-zero+1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}