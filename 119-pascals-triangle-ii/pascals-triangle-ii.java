class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        for(int i=0;i <= rowIndex;i++){
            if(i==0){
                res.add(1);
            }else{
                prev = new ArrayList<>(res);
                res.clear();

                res.add(1);
                for(int j=1;j<i;j++){
                    int curr = prev.get(j) + prev.get(j-1);
                    res.add(curr);
                }
                res.add(1);
            }
        }
        return res;
    }
}