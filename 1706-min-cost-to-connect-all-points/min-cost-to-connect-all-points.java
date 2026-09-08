class Solution {
    int parent[];
    int size[];
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        //initialize parent and size for DSU
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }


        //krushkal
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost = Math.abs(points[i][0] - points[j][0])
                            + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{cost,i,j});
            }
        }

        //sort with cost in ascending order
        Collections.sort(edges,(a,b) -> a[0]-b[0]);

        int totalCost=0;
        int noOfEdges=0;


        for(int i=0;i<edges.size();i++){
            int []edge = edges.get(i);
            int wt = edge[0];
            int u =edge[1];
            int v =edge[2];

            if(find(u) == find(v)){
                continue;
            }else{
                union(u,v);
                totalCost += wt;
                noOfEdges++;
            }

            if(noOfEdges == n-1){
                return totalCost;
            }
        }
        return 0;
    }
    

    //DSU - find function
    int find(int node){
        if(node == parent[node]) return node;

        return parent[node] = find(parent[node]);
    }

    //DSU - union function
    void union(int nodeA,int nodeB){
        int parA = find(nodeA);
        int parB = find(nodeB);

        if(size[parA] < size[parB]){
            parent[parA] = parB;
            size[parB] += size[parA];
        }else{
            parent[parB] = parA;
            size[parA] += size[parB];
        }
    }
}