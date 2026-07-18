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
    public class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode n,long i){
            node = n;
            idx = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        long maxwidth=0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            long minIndex = q.peek().idx; // First index of this level
            long first=0,last=0;

            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                
                long ind = curr.idx-minIndex; //normalize ... in case the idx become very large -> overflow can occur

                if(i == 0) first = ind;
                if(i == size-1) last = ind;

                if(node.left != null) q.add(new Pair(node.left,2*ind+1));
                if(node.right != null) q.add(new Pair(node.right,2*ind+2));
            }
            maxwidth = Math.max(maxwidth,last-first+1);
        }
        return (int)maxwidth;
    }
}