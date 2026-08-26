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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        //try starting from every node
        return (int)countFrom(root,(long)targetSum)
                +pathSum(root.left,targetSum)
                +pathSum(root.right,targetSum);
    }

    //it checks if i start from this node, how many valid paths exist
    long countFrom(TreeNode root,long target){
        if(root == null) return 0;

        long count = 0;

        if(root.val == target){
            count++;
        }

        count += countFrom(root.left,target-root.val);
        count += countFrom(root.right,target-root.val);

        return count;
    }
}