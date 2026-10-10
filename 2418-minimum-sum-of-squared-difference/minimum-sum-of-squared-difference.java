class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long budget = (long) k1+k2;
        //count stores number of times same differnce occured...
        //ex diff=[3,3,2].....count[3] = 2;
        int count[] = new int[100001]; //nums[i] can be only 10^5

        int maxDiff = 0;
        for(int i=0;i<nums1.length;i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            count[diff]++;
            maxDiff = Math.max(maxDiff,diff);
        }

        //dec differnces\
        for(int d = maxDiff; d > 0 && budget > 0; d--){
            int c = count[d];

            if(c == 0){
                continue;
            }

            if(budget >= c){
                //budget is more than the count of differnces
                //dec all differnces by -1 by storing into the count[d-1];
                count[d-1] += c;
                count[d]=0;
                budget -= c;
            }else{
                //if budget < count, we can only dec some(budget) differnces
                count[d-1] += (int) budget;
                count[d] -= (int) budget;
                budget = 0;
            }
        }

        long ans = 0;
        for(int diff=0;diff <= maxDiff;diff++){
            ans += (long) diff*diff*count[diff];
        }

        return ans;
    }
}