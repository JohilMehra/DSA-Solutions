class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        //here we are counting each bit occurance and divide by 3 (3 times occurance)
        //after divide if != 0, means that bit includes to the unique val/ans

        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int num : nums){
                if(((num >>> i) & 1) == 1){
                    count++;
                }
            }

            if(count % 3 != 0){
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}