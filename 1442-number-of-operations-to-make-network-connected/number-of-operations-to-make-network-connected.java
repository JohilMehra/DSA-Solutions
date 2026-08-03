class Solution {
    //approach - disjointset
    //1.find the extra edges in the graph
    //2.find the number of components
    //3. if the extra_edges >= no of components-1 then ans = no of components-1
    //   else -1 (not possible)
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        //1.count extra edges
        int cntExtras=0;

        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)){
                //means duplicate / extra edge
                cntExtras++;
            }else{
                // union/join edge
                ds.unionByRank(u,v);
            }
        }

        //2. find no of componets
        //when a node itself is a parent means component
        int nc=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i){
                nc++;
            }
        }

        if(cntExtras >= nc-1){
            return nc-1;
        }else{
            return -1;
        }
    }
}


//disjoint class
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }

        int url = findUPar(parent.get(node));
        parent.set(node,url);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int parA = findUPar(u);
        int parB = findUPar(v);

        if(parA == parB) return;
        if(rank.get(parA) < rank.get(parB)){
            parent.set(parA,parB);
        }else if(rank.get(parB) < rank.get(parA)){
            parent.set(parB,parA);
        }else{
            parent.set(parA,parB);
            rank.set(parA, rank.get(parA) + 1);//increase the rank
        }
    }
}