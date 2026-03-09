class Solution {
    public int findCircleNum(int[][] isConnected) {
        int  province=0;
        int n=isConnected.length;
        boolean[] vis=new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,i,vis);
                 province++;
            }
        }
        return province;
    }
    public static void dfs(int[][] graph,int city,boolean[] vis){
        vis[city]=true;

        for(int j=0;j<graph.length;j++){
            if(graph[city][j]==1 && !vis[j]){
                dfs(graph,j,vis);
            }
        }
    }
}