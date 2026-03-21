class Solution {
    public int countCompleteComponents(int n, int[][] edgegp) {
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) 
            graph[i]=new ArrayList<>();
        
        for(int[] e:edgegp){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                nodes=0;
                edges=0;
                dfs(graph,i,vis);

                edges=edges/2; //it counts double for undir graph

                if(edges == (nodes*(nodes-1))/2){
                    count++;
                }
            }
        }
        return count;        
    }
    static int nodes=0;
    static int edges=0;

    private static void dfs(ArrayList<Integer>[] graph,int curr,boolean[] vis){
        vis[curr]=true;
        nodes++;

        for(Integer neig:graph[curr]){
            edges++;
            if(!vis[neig]){
                dfs(graph,neig,vis);
            }
        }
    }
}