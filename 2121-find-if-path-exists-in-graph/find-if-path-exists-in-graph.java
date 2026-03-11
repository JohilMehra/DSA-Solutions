class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,ArrayList<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis=new boolean[n];
        return hasPath(graph,source,destination,vis);
    }

    public static boolean hasPath(Map<Integer,ArrayList<Integer>> graph,int src,int dest,boolean[] vis){
        vis[src]=true;
        if(src==dest) return true;

        for(Integer neig: graph.get(src)){
            if(!vis[neig]){
                if(hasPath(graph,neig,dest,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}