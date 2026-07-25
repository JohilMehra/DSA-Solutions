class Solution {
    class Pair{
        int dist,node;
        Pair(int d,int n){
            dist=d;
            node=n;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]> graph[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e : times){
            graph[e[0]].add(new int[]{e[1],e[2]});
        }

        int time[]=new int[n+1];
        Arrays.fill(time,(int)1e9);
        time[k]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (x,y) -> x.dist - y.dist
        );

        pq.offer(new Pair(0,k)); //(dis,src)
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int dist=curr.dist;
            int node=curr.node;

            for(int []it : graph[node]){
                int nextE=it[0];
                int edwt=it[1];

                if(dist+edwt < time[nextE]){
                    time[nextE]=dist+edwt;
                    pq.add(new Pair(time[nextE],nextE));
                }
            }
        }

        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(time[i]==(int)1e9) return -1;
            maxTime=Math.max(maxTime,time[i]);
        }

        return maxTime;
    }
}