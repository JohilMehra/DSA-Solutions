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
    HashMap<TreeNode,Integer> dp = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        //take
        int take = root.val;
        if(root.left != null){
            take += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            take += rob(root.right.left) + rob(root.right.right);
        }
        //not take
        int notTake = rob(root.left) + rob(root.right);

        int  ans = Math.max(take,notTake);

        dp.put(root,ans);

        return ans;
    }
}