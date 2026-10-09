class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                //closing bracket
                if(i+1 < s.length() && s.charAt(i+1) == ')'){
                    //means two ))
                    i++;
                }else{
                    //we need one ) bracket
                    insertions++;
                }

                if(open > 0){
                    open--; //matched case ())
                }else{
                    //we need a open ( bracket for matching 2 closing )) bracket
                    insertions++;
                }
            }
        }

        //if there are still open bracket , then we need 2*open bracket more closing bracket to make it balanced
        insertions += 2*open;

        return insertions;
    }
}