class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> revGraph=new ArrayList<>();
        for(int i=0;i<n;i++){
            revGraph.add(new ArrayList<>());
        }
        int[] outdeg=new int[n];
        for(int i=0;i<n;i++){
            outdeg[i]=graph[i].length;
            for(Integer neig: graph[i]){
                revGraph.get(neig).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdeg[i]==0){
                q.offer(i);
            }
        }
        boolean[] safe=new boolean[n];

        while(!q.isEmpty()){
            int curr=q.poll();
            safe[curr]=true;

            for(int parent : revGraph.get(curr)){
                outdeg[parent]--;

                if(outdeg[parent]==0){
                    q.offer(parent);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}