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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        findPaths(root);
        return res;
    }

    List<Integer> pathNum = new ArrayList<>();
    void findPaths(TreeNode root){
        if(root == null) return;

        pathNum.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder path = new StringBuilder();
            for(int i=0;i<pathNum.size();i++){
                path.append(pathNum.get(i));

                if(i != pathNum.size()-1){
                    path.append("->");
                }
            }
            res.add(path.toString());
        }
        findPaths(root.left);
        findPaths(root.right);
        pathNum.remove(pathNum.size()-1);
    }
}