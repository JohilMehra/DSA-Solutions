class Solution {
    int parent[];
    int size[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)){
                return new int[]{u,v};
            }else{
                union(u,v);
            }
        }
        return new int[]{-1,-1};
    }

    int find(int node){
        if(node == parent[node]) return node;

        return parent[node] = find(parent[node]);
    }

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