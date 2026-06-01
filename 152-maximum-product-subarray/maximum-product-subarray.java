class Solution {
    public int maxProduct(int[] nums) {
        //in this we take to variable called prefix and suffix
        //prefix--> starts from 0 index and multiple 
        //suffix starts from n-1 index and multiple
        //compare and update maxprod

        //in case pre or suff==0, update prefix or suffix =1

        int n=nums.length;
        int pre=1,suff=1;
        int maxprod=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            
            pre=pre*nums[i];
            suff=suff*nums[n-i-1];
            maxprod=Math.max(maxprod,Math.max(pre,suff));
        }
        return maxprod;
    }
}