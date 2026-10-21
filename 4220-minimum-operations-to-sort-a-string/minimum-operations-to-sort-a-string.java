class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) < s.charAt(i-1)){
                sorted = false;
                break;
            }
        }

        //case 1:if the string is already sorted, no operation needed
        if(sorted) return 0;

        //case 2:if the string is not sorted and having length of 2, return -1
        if(n == 2) return -1;

        //find min and max char of the string
        char mn = 'z', mx = 'a';
        for(char c : s.toCharArray()){
            mn = (char) Math.min(mn,c);
            mx = (char) Math.max(mx,c);
        }

        //case 3 : if either min or max ,or both are in there correct position, then we only need one operation to sort the string
        if(s.charAt(0) == mn || s.charAt(n-1) == mx){
            return 1;
        }

        //Check the middle positions
        for(int i = 1; i < n-1; i++){
            //case 4 : if min or max char at the middle, we need two operations
            if(s.charAt(i) == mn || s.charAt(i) == mx){
                return 2;
            }
        }

        //case 5 : this is the case, like if the min at end and max at first, we need 3 operations to sort , or any other case 
        return 3;
    }
}