class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[][] = new int[n][3];

        // Step 1: Store number, digit sum, and original index
        for(int i=0;i<n;i++){
            int num = nums[i];
            
            int sum = 0;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            
            arr[i][0] = nums[i];
            arr[i][1] = sum;
            arr[i][2] = i;
        }

        // Step 2: sort by digit sum, then by number
        Arrays.sort(arr, (a,b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        // step 3: count cycles
        boolean[] vis = new boolean[n];
        int swaps = 0;

        for(int i = 0; i < n; i++){
            if(vis[i] || arr[i][2] == i){
                continue; //no need, either it is already checked or correct position
            }

            int j = i;
            int cycleLen = 0;
            while(!vis[j]){
                vis[j] = true;
                j = arr[j][2]; //next index
                cycleLen++;
            }

            swaps += cycleLen - 1;
        }
        return swaps;

    }
}