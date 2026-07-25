class Solution {
    //max effort = max diff between two consecutive cells of the route
    //we have find a path having minmimum (max effort)

    class Tuple{
        int dis,r,c;
        Tuple(int dis,int r,int c){
            this.dis=dis;
            this.r=r;
            this.c=c;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length;

        PriorityQueue<Tuple> pq=new PriorityQueue<>(
            (x,y) -> x.dis - y.dis
        );
        int[][] dist =new int[n][m];
        for(int []row : dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));

        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int diff=curr.dis;
            int r=curr.r;
            int c=curr.c;

            if(r==n-1 && c==m-1) return diff;

            for(int []d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    //update the max effort diff
                    //max(maxdiff until , new(r&c) - old(r&c))
                    int neweffort=Math.max(diff,Math.abs(heights[nr][nc]-heights[r][c]));
                    if(neweffort < dist[nr][nc]){
                        dist[nr][nc]=neweffort;
                        pq.add(new Tuple(neweffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}