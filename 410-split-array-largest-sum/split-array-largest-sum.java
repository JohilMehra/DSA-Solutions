class Solution {
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int totalSum=0;
        for(int num:nums){
            max=Math.max(max,num);
            totalSum+=num;
        }

        int low=max,high=totalSum;
        int ans=totalSum;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(possiblesplit(nums,mid,k)){
                //means possible 
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean possiblesplit(int []nums,int maxPossibleSum,int k){
        int subarrayCnt=1,currSum=0;

        for(int num:nums){
            if(currSum + num > maxPossibleSum){
                subarrayCnt++;
                currSum=num;

                if(subarrayCnt > k){
                    return false;
                }
            }else{
                currSum+=num;
            }
        }
        return true; 
    }
}