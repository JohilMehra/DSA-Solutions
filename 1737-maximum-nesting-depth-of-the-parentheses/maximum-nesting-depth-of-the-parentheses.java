class Solution {
    public int maxDepth(String s) {
        int maxdepth=0;
        int currdepth=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                currdepth++;
            }else if(ch==')'){
                currdepth--;   
            }
            maxdepth=Math.max(maxdepth,currdepth);
        }
        return maxdepth;
    }
}