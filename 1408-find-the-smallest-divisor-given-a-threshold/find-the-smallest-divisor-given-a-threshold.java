class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }

        int low=1,high=max;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            int res=findDivisor(nums,mid);
            if(res<=threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private static int findDivisor(int[] nums,int div){
        int count=0;
        for(int num : nums){
            // count+= (int)Math.ceil((double)nums[i]/mid);
            count += (num + div - 1) / div;
        }
        return count;
    }
}