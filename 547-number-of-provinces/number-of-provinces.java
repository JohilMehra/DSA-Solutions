class Solution {
    public int findCircleNum(int[][] isConnected) {
        //count no of connected components
        int provinces=0;

        int n = isConnected.length; //no of nodes
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis);
                provinces++;
            }
        }
        return provinces;
    }
    void dfs(int currNode,int[][] isConnected,boolean[] vis){
        vis[currNode]=true;

        for(int i=0;i<isConnected.length;i++){
            //traverse all its directly and undirectly neighbours and mark it as visited
            if(isConnected[currNode][i]==1 && !vis[i]){
                dfs(i,isConnected,vis);
            }
        }
    }
}