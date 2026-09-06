class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int []pse = new int[n]; //stores previoius smallest ele for index i;
        int []nse = new int[n]; //stores next smallest ele for index i

        Stack<int[]> s = new Stack<>();

        //create pse array
        for(int i=0;i<n;i++){
            
            while(!s.isEmpty() && s.peek()[0] >= heights[i]){
                //if stack top ele >= curr height ,this cannot be a pse, remove it
                s.pop();
            }
            if(s.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i] = s.peek()[1];
            }
            s.push(new int[]{heights[i],i});
        }

        s.clear();

        //create nse array
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()[0] >= heights[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nse[i]=n; //out of bound, no nse exist for i
            }else{
                nse[i] = s.peek()[1];
            }
            s.push(new int[]{heights[i],i});
        }

        int max = 0;
        for(int i=0;i<n;i++){
            int width = nse[i] - pse[i] - 1;
            int height = heights[i];
            int area = width * height;
            max = Math.max(max, area);
        }

        return max;
    }
}