class Solution {
    //moore's voting algo
    public int majorityElement(int[] nums) {
        int cnt=0;
        int ele=nums[0];
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                ele=nums[i];
                cnt=1;
            }else if(nums[i]==ele){
                cnt++;
            }else{
                cnt--;
            }
        }
        //check how much time it appears
        int cnt1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                cnt1++;
            }
        }
        //only acceptable if appeared > n/2 times
        if(cnt1 > (nums.length)/2){
            return ele;
        }
        return -1;
    }
}