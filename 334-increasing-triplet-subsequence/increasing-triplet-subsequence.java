class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= first){
                first = num;
            }else if(num <= sec){
                sec = num;
            }else{
                //if found already 2 ele less than the curr ele
                //this is the third ele -> contains such 3 elements based on condition
                return true;
            }
        }
        return false;
    }
}