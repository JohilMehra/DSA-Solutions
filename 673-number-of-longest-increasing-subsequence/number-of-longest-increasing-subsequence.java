class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int len[] = new int[n]; //dp
        int count[] = new int[n];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && len[j]+1 > len[i]){
                    //if it increases the existing length
                    //update the len
                    len[i]=len[j]+1;
                    //assign update count
                    count[i]=count[j];
                }else if(nums[j] < nums[i] && len[j]+1 == len[i]){
                    //if same length LIS repeats again
                    //increase the count
                    count[i] += count[j];
                }
            }
            max=Math.max(len[i],max);
        }
        //calculate total LIS :-  it can be at different location
        //like in ex:2 at LIS:1 and we have to count all counts with having len=1 
        int total=0;
        for(int i=0;i<n;i++){
            if(len[i]==max){
                total+=count[i];
            }
        }
        return total;
    }
}