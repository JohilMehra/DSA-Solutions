class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        //sort by end index
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));

        int count = 0;
        int curr[] = intervals[0];

        for(int i = 1; i < n; i++){
            if(intervals[i][0] < curr[1]){
                count++;
            }else{
                curr = intervals[i];
            }
        }
        return count;
    }
}