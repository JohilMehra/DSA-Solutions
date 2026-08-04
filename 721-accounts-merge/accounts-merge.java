class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail) == false){
                    map.put(mail,i);
                }else{
                    ds.unionByRank(i,map.get(mail));
                }
            }
        }

        ArrayList<String> []mergeMail = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergeMail[i]=new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(i).get(0)); //name
            for(String str : mergeMail[i]){
                ls.add(str);
            }

            ans.add(ls);
        }

        return ans;
    }
}

//DisjointSet class
class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findPar(int node){
        if(node == parent.get(node)) return node;

        int ulp=findPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionByRank(int u,int v){
        int parA = findPar(u);
        int parB = findPar(v);

        if(parA == parB) return;

        if(rank.get(parA) < rank.get(parB)){
            parent.set(parA,parB);
        }else if(rank.get(parB) < rank.get(parA)){
            parent.set(parB,parA);
        }else{
            parent.set(parA,parB);
            rank.set(parB,rank.get(parB)+1);
        }
    }
}