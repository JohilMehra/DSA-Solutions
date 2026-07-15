/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ls = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currnode = q.poll();
                ls.add(currnode.val);
                if(currnode.left != null) q.add(currnode.left);
                if(currnode.right != null) q.add(currnode.right);
            }
            res.add(ls);
        }
        return res;
    }
}