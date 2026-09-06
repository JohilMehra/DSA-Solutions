class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int heights[] = new int[m];

        long max = 0;

        for(int i=0;i<n;i++){
            //for the current row, build the histogram heights.
            //if matrix[i][j] is '1', increase the consecutive height.
            //if it is '0', reset the height to 0.
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }
            // Treat the current row as a histogram and find
            // the largest rectangle that can be formed from it.
            long currRowMax =largestRectangle(heights);
            max = Math.max(max,currRowMax);
        }

        return (int)max;
    }

    long largestRectangle(int []heights){
        //this is optimal approach , can find using PSE and NSE array,already done in leetcode 84 problem
        int n=heights.length;

        // Monotonic increasing stack storing indices.
        // When the current height is smaller than the stack top,
        // the popped element has found its right boundary.
        Stack<Integer> s = new Stack<>(); //stores indices

        long max =0;

        // Process every histogram bar.
        // At i == n, use height 0 to force remaining elements to pop.
        for(int i=0;i<=n;i++){
            int currheight = (i==n) ? 0 : heights[i];

            // If current height is smaller/equal, the popped bar
            // cannot extend to the right beyond index i.
            while(!s.isEmpty() && heights[s.peek()] >= currheight){
                int ind = s.pop(); //popped ele index
                //we are calculating area for the popped element
                int height = heights[ind];
                // After popping, stack top gives the nearest smaller
                // element on the left.
                int left = s.isEmpty() ? -1 : s.peek();

                int width = i - left - 1;
                long area = height * width;
                max = Math.max(max,area);
            }

            // Don't push i == n because n is outside the array.
            if(i<n){
                s.push(i);
            }
        }
        return max;
    }
}