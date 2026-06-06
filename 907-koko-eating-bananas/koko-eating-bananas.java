class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=findMax(piles);

        int low=1,high=max;

        while(low<=high){
            int mid=low+(high-low)/2;
            int countHr=count_Hr(piles,mid);
            if(countHr<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int findMax(int[] piles){
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        return max;
    }

    private static int count_Hr(int[] piles,int k){
        int totalHr=0;
        for(int i=0;i<piles.length;i++){
            totalHr+=Math.ceil((double)piles[i] / (double)k);
        }
        return totalHr;
    }
}