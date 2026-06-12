class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        int low=0;
        int high=(n*m -1);

        while(low<=high){
            int mid=low+(high-low)/2;
            // mid / m --> row no
            // mid % 4 --> column no
            int currNum=matrix[mid/m][mid%m];
            if(currNum == target){
                return true;
            }else if(currNum < target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}