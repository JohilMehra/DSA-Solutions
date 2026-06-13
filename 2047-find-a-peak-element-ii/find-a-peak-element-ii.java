class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int low=0,high=m-1;
        while(low<=high){
            int mid=(low+high)/2;  //column
            int row=maxNumIdx(mat,n,m,mid); //max ele in that col

            int left= mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right= mid+1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            else if(mat[row][mid] < left){
                //eliminate right half and keep left half 
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int maxNumIdx(int[][] mat,int n,int m,int col){
        int maxValue=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col] > maxValue){
                maxValue=mat[i][col];
                index=i;
            }
        }
        return index;
    }
}