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
    Map<Integer,Integer> freq = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        findSum(root);
        int maxfreq = 0;
        for(Integer value : freq.values()){
            maxfreq = Math.max(maxfreq,value);
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value == maxfreq){
                lst.add(key);
            }
        }

        int []res = new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            res[i]=lst.get(i);
        }
        return res;
    }
    int findSum(TreeNode root){
        if(root == null) return 0;

        int left = findSum(root.left);
        int right = findSum(root.right);

        int sum = root.val + left + right;
        freq.put(sum,freq.getOrDefault(sum,0)+1);

        return sum;
    }
}