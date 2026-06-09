class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0,high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1); //it tells how many missing no in that position

            if(missing < k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        //now high stands left side whereas low stands at right side 
        //missing no is in between them 

        //how many missing no in high pos
        // int missing=arr[high]-(high+1);
        //how many more steps pending to get the kth missing
        // int more=k-missing;

        // return arr[high]+more;
        //in this case if high=-1 it will shows arrayOutOfBound error

        //return either high+k+1 or low+k

        return low+k; 
    }
}