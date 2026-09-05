class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        int last[] = new int[26]; //helps to check weather,the curr ele is availble later
        boolean used[] = new boolean[26]; //works like set

        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a'] = i;
            //stores the last index of apperance
        }

        StringBuilder stack = new StringBuilder(); //works like stack 

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(used[ch-'a']){
                continue; //if already a part of answer, skip it 
            }

            while(stack.length() > 0){
                int top = stack.charAt(stack.length()-1);

                if(top > ch && last[top-'a'] > i){
                    //if top is grater and top char is avilable later in greater index then curr index
                    stack.deleteCharAt(stack.length()-1);
                    //then , make the top char unused
                    used[top-'a'] = false; 
                }else{
                    break;
                }
            }
            stack.append(ch);
            used[ch-'a']=true;
        }
        return stack.toString();
    }
}