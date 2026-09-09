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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        //go every node of the main tree and compare with subroot
        if(isSameTree(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    boolean isSameTree(TreeNode s, TreeNode t){
        //if both null
        if(s == null && t == null){
            return true;
        }
        //if any one of them is null
        if(s == null || t == null){
            return false;
        }

        //if values doesn't matched
        if(s.val != t.val){
            return false;
        }

        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);

    }
}