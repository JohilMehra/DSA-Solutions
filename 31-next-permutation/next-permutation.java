class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;  //break point 
                break;
            }
        }

        if(idx==-1){
            //if no break point means the seq is the last seq like 
            // 54321 --next no--> 12345
            reverse(nums,0,nums.length-1);
            return;
        }

        //swap break point idx no. with smallest no in right side
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }

        //reverse subarray at right of break point
        reverse(nums,idx+1,nums.length-1);
    }
    private void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}