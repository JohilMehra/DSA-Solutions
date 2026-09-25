class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = -1;
        int n = grid.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=0;j<n;j++){
                if(set.contains(grid[i][j])){
                    a = grid[i][j];
                    found = true;
                    break;
                }
                set.add(grid[i][j]);
            }
            if(found) break;
        }

        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                total += grid[i][j];
            }
        }

        int m = n*n;
        int actualtotal = (m*(m+1))/2;

        int b = actualtotal - total + a;

        return new int[]{a,b};
    }
}