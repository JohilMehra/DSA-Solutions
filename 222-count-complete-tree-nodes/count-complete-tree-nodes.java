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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftH = leftSideHeight(root);
        int rightH = rightSideHeight(root);

        if(leftH == rightH){
            return ((2<<(leftH))-1); //2^h-1
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right); 
        }
    }

    public int leftSideHeight(TreeNode root){
        int count=0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightSideHeight(TreeNode root){
        int count=0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}