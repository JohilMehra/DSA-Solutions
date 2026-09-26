class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(List<String> knld : knowledge){
            String key = knld.get(0);
            String value = knld.get(1);
            map.put(key,value);
        }
        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == '('){
                StringBuilder k = new StringBuilder();
                i++;
                while(s.charAt(i) != ')'){
                    k.append(s.charAt(i));
                    i++;
                }
                i++;
                String keyStr = k.toString();
                if(map.containsKey(keyStr)){
                    sb.append(map.get(keyStr));
                }else{
                    sb.append("?");
                }
            }else{
                sb.append(ch);
                i++;
            }
        }
        return sb.toString();
    }
}