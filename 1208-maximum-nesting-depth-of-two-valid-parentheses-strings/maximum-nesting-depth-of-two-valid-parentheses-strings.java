class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int []res = new int[seq.length()];
        int bal = 0;

        for(int i=0;i<seq.length();i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                bal++;
                res[i] = bal%2;
            }else{
                res[i] = bal%2;
                bal--;
            }
        }
        return res;
    }
}