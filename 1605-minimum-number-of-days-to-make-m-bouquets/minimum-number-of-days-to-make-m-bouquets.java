class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long) m * k > n) return -1; //flower are not availble for making bouquet

        int min_day=Integer.MAX_VALUE,max_day=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min_day=Math.min(min_day,bloomDay[i]);
            max_day=Math.max(max_day,bloomDay[i]);
        }
        int low=min_day,high=max_day;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            int val=countBouquet(bloomDay,k,mid);
            if(val>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private static int countBouquet(int[] bloom,int k,int day){
        int count=0;
        int total=0;

        for(int i=0;i<bloom.length;i++){
            if(bloom[i]<=day){
                count++;
            }else{
                total+=count/k;
                count=0;
            }
        }
        total+=count/k;
        return total;
    }
}