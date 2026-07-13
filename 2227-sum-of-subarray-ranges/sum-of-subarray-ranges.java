class Solution {
    public long subArrayRanges(int[] nums) {
        // sum of all largest ele - sum of all smallest ele 
        //find smallest is same as leetcode 907
        return largestSum(nums) - smallestSum(nums);
    }

//1. sum of all smallest ele 
    long smallestSum(int[] nums){
        int n=nums.length;
        // find Previous smallest ele
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>(); // we are storing indices

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        //find Next smallest ele 
        int[] nse = new int[n];
        st = new Stack<>(); // we are storing indices

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){ // = for duplicates like[3,3]
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        //total sum of minimum
        long totalMin=0;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            totalMin += freq * nums[i];
        }

        return totalMin;
    }


//2.sum of all largest ele
    long largestSum(int[] nums){
        int n=nums.length;
        // find Previous smallest ele
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>(); // we are storing indices

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        //find Next smallest ele 
        int[] nse = new int[n];
        st = new Stack<>(); // we are storing indices

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){ // = for duplicates like[3,3]
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        //total sum of minimum
        long totalMax=0;
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            totalMax += freq * nums[i];
        }

        return totalMax;
    }
}