class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        boolean evenAll = true;
        for(int num : nums1){
            if(num % 2 != 0){
                evenAll = false;
                break;
            }
        }
        if(evenAll) return true;

        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                //if even -> make it odd
                boolean odd = false;
                for(int j=0;j<n;j++){
                    if(i != j && nums1[j]%2!=0){
                        odd=true;
                    }
                }
                if(!odd) return false;
            }
        }

        return true;
    }
}