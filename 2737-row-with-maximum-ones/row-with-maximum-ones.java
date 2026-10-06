class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int idx = -1;
        int cnt = -1;

        for(int i=0;i<mat.length;i++){
            int ones = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    ones++;
                }
            }
            if(ones > cnt){
                cnt = ones;
                idx = i;
            }
        }
        return new int[]{idx,cnt};
    }
}