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
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        solve(root);
        return max;
    }
    int solve(TreeNode root){ //counting edges instead of nodes
        if(root == null) return 0;
        
        int leftLen = solve(root.left);
        int rightLen = solve(root.right);

        int left = 0;
        int right = 0;

        //if it matches with left node , than add edge 
        if(root.left != null && root.left.val == root.val){
            left = leftLen+1;
        }
        //if it matches with right node, then add edge
        if(root.right != null && root.right.val == root.val){
            right = rightLen+1;
        }

        max = Math.max(max,left+right);

        return Math.max(left,right);
    }
}