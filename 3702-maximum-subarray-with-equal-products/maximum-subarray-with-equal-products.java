class Solution {
    public int maxLength(int[] nums) {
        int n =  nums.length;
        int max = 0;

        for(int i=0; i<n; i++){
            long currprod = 1L;
            int lastgcd = 0;
            long lastlcm = 1L;

            for(int j=i; j<n; j++){
                currprod *= nums[j];
                lastgcd = (j == i) ? nums[j] : gcd(lastgcd,nums[j]);
                lastlcm = lcm(lastlcm,nums[j]);


                if(currprod == lastlcm * lastgcd){
                    max = Math.max(max,j-i+1);
                } 
            }
        }
        return max;
    }

    int gcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    long lcm(long a, long b){
        return (a/gcd((int) a,(int) b)) * b;
    }
}