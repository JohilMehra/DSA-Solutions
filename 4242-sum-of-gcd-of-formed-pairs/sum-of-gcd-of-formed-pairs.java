class Solution {
    public long gcdSum(int[] nums) {
        int max=-1, n= nums.length;
        int prefGcd[] = new int[n];

        for(int i=0; i<n; i++){
            max=Math.max(max,nums[i]);
            prefGcd[i]=gcd(nums[i],max);
        }

        Arrays.sort(prefGcd);

        long ans=0;
        for(int i=0,j=n-1; i<j; i++,j--){
            ans += gcd(prefGcd[i],prefGcd[j]);
        }

        return ans;
    }

    private int gcd(int a,int b){
        if(b==0) return a;

        return gcd(b,a%b);
    }
}