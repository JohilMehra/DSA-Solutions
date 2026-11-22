class Solution {
    public boolean checkString(String s) {
        boolean bs = false;

        for(char ch : s.toCharArray()){
            if(ch == 'a' && bs == true){
                return false;
            }else if(ch == 'b' && bs == false){
                bs = true;
            }
        }
        return true;
    }
}