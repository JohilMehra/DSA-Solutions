class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(sb.toString());
                sb.setLength(0);//reset
            }else if(ch == ')'){
                sb.reverse();

                sb.insert(0,st.pop());
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}