/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        buildParent(root,null,parent);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visited.add(target);

        int dis = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(dis == k){
                List<Integer> res = new ArrayList<>();
                while(!q.isEmpty()){
                    TreeNode curr = q.poll();
                    res.add(curr.val);
                }
                return res;
            }

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                TreeNode par = parent.get(curr);
                if(par != null && visited.add(par)){
                    q.offer(par);
                }
            }
            dis++;
        }
        return new ArrayList<>();
    }

    public void buildParent(TreeNode node,TreeNode par,Map<TreeNode,TreeNode> parent){
        if(node == null) return;

        parent.put(node,par);
        buildParent(node.left,node,parent);
        buildParent(node.right,node,parent);
    }
}