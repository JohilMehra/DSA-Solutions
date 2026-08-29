class Solution {
    //same lIS , in last check wheather len >= 3 or not
    public boolean increasingTriplet(int[] arr) {
        int []tail = new int[arr.length];
        tail[0]=arr[0];
        int len=1;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>tail[len-1]){
                len++;
                tail[len-1]=arr[i];
            }else{
                //binary search and find lower bound
                int left = 0, right=len;
                while(left<right){
                    int mid = left+(right-left)/2;
                    if(tail[mid]<arr[i]){
                        left=mid+1;
                    }else{
                        right=mid;
                    }
                }
                tail[left]=arr[i];
            }
        }
        return len >= 3;
    }
}