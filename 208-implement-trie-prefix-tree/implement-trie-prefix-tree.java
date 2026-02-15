class Trie {

    static class Node{
        Node[] children=new Node[26];
        boolean eow=false;
    }
    public Node root;

    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        Node curr=root;
        for(char ch: word.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr=root;
        for(char ch: prefix.toCharArray()){
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */