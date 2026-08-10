class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int deletions=0;
        Set<Integer> set = new HashSet<>();
        for(char key : map.keySet()){
            int freq = map.get(key);
            while(set.contains(freq) && freq>0){
                freq--;
                deletions++;
            }
            if(freq > 0){
                set.add(freq);
            }
        }
        return deletions;
    }
}