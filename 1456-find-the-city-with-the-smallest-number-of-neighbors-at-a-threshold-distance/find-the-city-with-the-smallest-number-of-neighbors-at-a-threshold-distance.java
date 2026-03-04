class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //build adjancency list
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int finalcity=-1;
        int min=Integer.MAX_VALUE;
        //dijkstra
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);

            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
            pq.offer(new int[]{0,i});
            dist[i]=0;

            while(!pq.isEmpty()){
                int[] curr=pq.poll();
                int distance=curr[0];
                int node=curr[1];

                for(int[] neig:adj.get(node)){
                    int nextNode=neig[0];
                    int weight=neig[1];

                    if(distance+weight<dist[nextNode]){
                        dist[nextNode]=distance+weight;
                        pq.offer(new int[]{dist[nextNode],nextNode});
                    }
                }
            }
            int count=0;
            for(int j=0;j<n;j++){
                if(j!=i && dist[j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min=count;
                finalcity=i;
            }
        }
        return finalcity;
    }
}