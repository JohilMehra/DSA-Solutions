class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //in this problem max output is 2 numbers
        //we consider that two numbr as candtiate 1 and 2
        int candidate1=0,candidate2=0;
        int cnt1=0,cnt2=0;

        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i] != candidate2){
                candidate1=nums[i];
                cnt1=1;
            }else if(cnt2==0 && nums[i] != candidate1){
                candidate2=nums[i];
                cnt2=1;
            }else if(nums[i]==candidate1){
                cnt1++;
            }else if(nums[i]==candidate2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res=new ArrayList<>();
        int threshold=nums.length/3;

        cnt1=0;
        cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(candidate1==nums[i]){
                cnt1++;
            }else if(candidate2==nums[i]){
                cnt2++;
            }
        }

        if(cnt1>threshold){
            res.add(candidate1);
        }
        if(cnt2>threshold){
            res.add(candidate2);
        }

        return res;
    }
}