class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0] );

        ArrayList<int[]> res=new ArrayList<>();
        int[] current=intervals[0];
        for(int i=1;i<n;i++){
            if(current[1]>=intervals[i][0]){
                current[1]=Math.max(current[1],intervals[i][1]);
            }else{
                res.add(current);
                current=intervals[i];
            }
        }

        //last interval
        res.add(current);

        return res.toArray(new int[res.size()][]);
    }
}