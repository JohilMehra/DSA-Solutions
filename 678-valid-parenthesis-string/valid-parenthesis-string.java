class Solution {
    public boolean checkValidString(String s) {
        int low = 0; //minimum possible number of unmatched (
        int high = 0; //maximum possible number of unmatched (

        for(char ch : s.toCharArray()){
            if(ch == '('){
                low++;
                high++;
            }else if(ch == ')'){
                low--;
                high--;
            }else {
                //when '*' comes
                low--; // * treat as ')'
                high++; // * treat as '('
            }

            //in case if high < 0 means there are too many ) brackets
            if(high < 0){
                return false;
            }

            low = Math.max(0,low); //don't let low < 0, not possible
        }
        return low == 0;
    }
}