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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calPathSum(root);
        return maxSum;
    }
    private int calPathSum(TreeNode root){
        if(root == null) return 0;
        //if path is neg -> consider as 0
        int left =  Math.max(0,calPathSum(root.left));
        int right = Math.max(0,calPathSum(root.right));

        maxSum = Math.max(maxSum, left+right+root.val);

        return root.val + Math.max(left,right);
    }
}