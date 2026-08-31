class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //insted of subsequence, we have to find subset -> sort it 
        Arrays.sort(nums);

        int n = nums.length;
        int len[] = new int[n];
        int par[] = new int[n];

        for(int i=0;i<n;i++){
            len[i]=1;
            par[i]=i;
        }

        int max=1,lastIdx=0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if((nums[i]% nums[j]) == 0 && len[j]+1 > len[i]){
                    len[i] = len[j]+1;
                    par[i] = j;
                }
            }
            if(len[i] > max){
                max = len[i];
                lastIdx = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIdx]);

        while(par[lastIdx] != lastIdx){
            lastIdx = par[lastIdx];
            res.add(nums[lastIdx]);
        }

        Collections.reverse(res);
        return res;
    }
}