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

    class NodeInfo{
        int row,col,val;
        NodeInfo(int r, int c, int v){
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }
    List<NodeInfo> list = new ArrayList<>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);

        //2.Sort
        Collections.sort(list,(a,b)->{
            //col -> row -> val
            if(a.col != b.col)
                return a.col-b.col;

            if(a.row != b.row)
                return a.row-b.row;

            return a.val-b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        //3. group by column
        int prevCol = Integer.MIN_VALUE;
        for(NodeInfo node : list){
            if(node.col != prevCol){
                //if next col came -> add new list in final res
                res.add(new ArrayList<>());
                prevCol = node.col;
            }

            //add val to last/curr list of the res
            res.get(res.size()-1).add(node.val);
        }
        

        return res;
    }

    //1. DFS & Store
    private void helper(TreeNode root,int row,int col){
        if(root == null){
            return;
        }
        list.add(new NodeInfo(row,col,root.val));
        helper(root.left, row+1, col-1);
        helper(root.right, row+1, col+1);
    }
}