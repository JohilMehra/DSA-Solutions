class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int currGCD=0;
            for(int j=i;j<n;j++){
                currGCD=gcd(currGCD,nums[j]);

                if(currGCD == k) count++;
                if(currGCD < k) break;
            }

        }
        return count;
    }
    private static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}