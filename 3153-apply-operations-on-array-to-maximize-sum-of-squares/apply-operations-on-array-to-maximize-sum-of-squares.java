class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1000000007;
        int bitCount[] = new int[31];
        for(int num : nums){
            for(int bit=0;bit<31;bit++){
                if((num & (1 << bit)) != 0){
                    bitCount[bit]++;
                }
            }
        }

        long total = 0;
        for(int i=0; i<k; i++){
            int num = 0;
            for(int bit = 0; bit < 31; bit++){
                if(bitCount[bit] > 0){
                    num |= (1 << bit);
                    bitCount[bit]--;
                }
            }

            total = (total + (long) num * num) % MOD;
        }
        return (int) total;
    }
}