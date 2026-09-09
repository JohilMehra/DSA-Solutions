class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;

        long totalCommas = 0;
        long start = 1000;
        long commas = 1;

        while(start <= n){
            long end = start*1000-1;

            long currEnd = Math.min(end,n);

            if(currEnd >= start){
                totalCommas += (currEnd-start+1) * commas;
            }
            start = start*1000;
            commas++;
        }

        return totalCommas;
    }
}