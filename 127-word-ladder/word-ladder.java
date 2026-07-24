class Solution {
    //BFS + shortest path
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //works like visited array/possibility
        Set<String> set = new HashSet<>(wordList);
        //in case the endWord/destination is not in the wordList
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q =new LinkedList<>();
        //start with source word
        q.offer(beginWord);

        int level=1;//count no of words

        while(!q.isEmpty()){
            int size=q.size();
            //go level by level
            for(int i=0;i<size;i++){
                String word = q.poll();

                if(word.equals(endWord)){
                    //if it reaches the destination ,return the level
                    return level;
                }
                //Ex: hit->['h','i'.'t']
                char []arr = word.toCharArray();

                //replace each char of word with range a-z 
                //add in sequence if new word is availble in set/wordlist

                for(int j=0;j<arr.length;j++){
                    char original = arr[j];//Ex: h/i/t

                    //replace each char of word with range a-z 
                    //add in sequence if new word is availble in set/wordlist
                    for(char c='a'; c<='z'; c++){
                        if(c==original) continue;

                        arr[j]=c;//replace char with new char
                        //convert in string
                        String next = new String(arr);

                        if(set.contains(next)){
                            //if set contains new string add in queue
                            q.offer(next);
                            //remove for set to avoid duplication
                            set.remove(next);
                        }
                    }
                    //reset char to original for next word
                    arr[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}