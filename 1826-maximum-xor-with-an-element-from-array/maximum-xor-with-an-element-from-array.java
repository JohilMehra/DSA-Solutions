public class TrieNode{
    TrieNode []child=new TrieNode[2];
}
class Trie{
    TrieNode root=new TrieNode();
    public void insert(int num){
        TrieNode curr=root;

        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;

            if(curr.child[bit]==null){
                curr.child[bit]=new TrieNode();
            }
            curr=curr.child[bit];
        }
    }

    public int getMaxXor(int num){
        TrieNode curr=root;
        int maxXor=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            int opposite=1-bit;

            if(curr.child[opposite]!=null){
                maxXor |=(1<<i);
                curr=curr.child[opposite];
            }else{
                curr=curr.child[bit];
            }
        }
        return maxXor;
    }
}
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q=queries.length;

        // store [mi, xi, index]
        int [][]offline=new int[q][3];
        for(int i=0;i<q;i++){
            offline[i][0]=queries[i][1];//mi
            offline[i][1]=queries[i][0];//xi
            offline[i][2]=i;//index
        }
        Arrays.sort(offline,(a,b) -> a[0]-b[0]);

        Trie trie=new Trie();
        int[] ans=new int[q];

        int j=0;

        for(int i=0;i<q;i++){
            int mi=offline[i][0];
            int xi=offline[i][1];
            int idx=offline[i][2];

            //insert all nums<=mi
            while(j<nums.length && nums[j]<=mi){
                trie.insert(nums[j]);
                j++;
            }

            //if no element inserted yet
            if(j==0)
                ans[idx]=-1;
            else
                ans[idx]=trie.getMaxXor(xi);
        }

        return ans;
    }
}