class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int longest=1;
        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int x=num;

                while(set.contains(x+1)){
                    x+=1;
                    count+=1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}