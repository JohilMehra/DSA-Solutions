class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        int n=graph.length-1;
        printAllPath(graph,0,n,res,new ArrayList<>());
        return res;
    }

    public static void printAllPath(int[][] graph,int src,int dest,List<List<Integer>> res,List<Integer> path){

        path.add(src);

        if(src==dest){
            res.add(new ArrayList<>(path));
        }

        for(int neig: graph[src]){
            printAllPath(graph,neig,dest,res,path);
        }

        path.remove(path.size()-1);
    }
}