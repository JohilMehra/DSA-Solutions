class Solution {
    //1.reverse edges
    //2.add nodes having indegree 0 & perform toposort 

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<Integer> ngraph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            ngraph[i]=new ArrayList<>();
        }

        int []indegree = new int[n];
        for(int i=0;i<n;i++){
            //we are storing in reverse order
            for(int j=0;j<graph[i].length;j++){
                int v=graph[i][j];
                ngraph[v].add(i);

                indegree[i]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);

            for(Integer it : ngraph[curr]){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}