/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return res;

        List<Integer> lst = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node currRoot = q.poll();
                lst.add(currRoot.val);
                for(Node child : currRoot.children){
                    q.add(child);
                }
            }
            res.add(lst);
            lst = new ArrayList<>();
        }
        return res;
    }
}