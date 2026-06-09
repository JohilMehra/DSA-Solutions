class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int weight:weights){
            max=Math.max(max,weight);
            sum+=weight;
        }

        int low=max,high=sum;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            int countDays=findCapacity(weights,mid);
            if(countDays<=days){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static int findCapacity(int[] weights,int cap){
        int loud=0;
        int days=1;
        for(int weight:weights){
            if(loud + weight > cap){
                // shift to next day
                days=days+1;
                loud=weight; //new loud
            }else{
                //add weight/loud in same day 
                loud+=weight;
            }
        }
        return days;
    }
}