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
    int ans;
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        ans=0;
        solve(root,0,0);
        return ans;
    }

    int[] solve(TreeNode root,int sum,int count){
        if(root == null) return new int[]{0,0}; //(sum,count)

        int []left = solve(root.left,sum,count);
        int []right = solve(root.right,sum,count);

        int pathSum = root.val + left[0] + right[0];
        int pathCount = 1 + left[1] + right[1];

        int avg = pathSum/pathCount;
        if(avg == root.val) ans++;

        return new int[]{pathSum,pathCount};
    }
}