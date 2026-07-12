class Solution {
    int mod = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int []nse = findNSE(arr);
        int []pse = findPSE(arr);

        long total=0;
        for(int i=0;i<n;i++){
            //we are finding how many times a ele as the minimum
            long left = i - pse[i]; //find left subarray ele no.
            long right = nse[i] - i; //right subaary ele no.

            total = (total + (left * right * arr[i]) % mod) % mod;
        }
        return (int)total;
    }

    int[] findNSE(int []arr){

        Stack<Integer> st = new Stack<>();
        int[] nse =  new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    int[] findPSE(int []arr){

        Stack<Integer> st = new Stack<>();
        int[] pse =  new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}