class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    Boolean dp[][]; //stores null by default
    int []stones;
    public boolean canCross(int[] stones) {
        this.stones = stones;
        int n = stones.length;

        dp = new Boolean[n][n+1]; //(indices,jumps(0,1,....n+1))

        for(int i=0;i<n;i++){
            map.put(stones[i],i); 
            //help to find whether the next position is possible (or) not and finding the index of nextPossible Position
        }
        return solve(0,0); //(index,lastJump)
    }

    boolean solve(int ind,int lastjump){
        //reached the last stone
        if(ind == stones.length-1) return true;

        if(dp[ind][lastjump] != null) return dp[ind][lastjump];

        // Try (lastJump-1, lastJump, lastJump+1)
        for(int jump = lastjump-1; jump<=lastjump+1;jump++){
            if(jump <= 0){
                continue;
            }

            int nextPos = stones[ind] + jump;

            if(map.containsKey(nextPos)){
                //possible

                //the index of the next position
                int nextInd = map.get(nextPos);

                if(solve(nextInd,jump)){ //go next index
                    return dp[ind][lastjump] = true;
                }
            }
        }
        return dp[ind][lastjump] = false;
    }
}