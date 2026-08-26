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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;

        List<Integer> path = new ArrayList<>();

        findPath(root,targetSum,path);
        return res;
    }

    void findPath(TreeNode root,int target,List<Integer> path){
        if(root == null) return;

        path.add(root.val);

        if(root.left == null && root.right == null && root.val == target){
           res.add(new ArrayList<>(path));
        }else{
            int rem = target-root.val;

            findPath(root.left,rem,path);
            findPath(root.right,rem,path);
        }

        path.remove(path.size()-1);
    }
}