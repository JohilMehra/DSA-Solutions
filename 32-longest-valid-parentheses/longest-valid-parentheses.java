class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>(); //stores the boundaries of valid parentheses starts from
        st.push(-1);//start boundary initially
        
        int max =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                //st.pop() -> match with current ')' 
                st.pop();

                if(st.isEmpty()){
                    st.push(i); //new valid parantheses boundary
                }else{
                    int len = i - st.peek(); //tells the valid parantheses substring length
                    max = Math.max(max,len);
                }
            }
        }
        return max;
    }
}