class Solution {
    class State{
        int r,c,energy,mask,moves;
        State(int r,int c,int energy,int mask,int moves){
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length, m = classroom[0].length();
        
        int startR = -1, startC = -1;

        int[][] litterIndex = new int[n][m];
        for (int[] row : litterIndex) {
            java.util.Arrays.fill(row, -1);
        }

        int litterCount = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }
        // If there is no litter
        if (litterCount == 0) {
            return 0;
        }

        int allMask = (1 << litterCount) - 1;
        
        //visited[r][c][energy][mask]
        boolean[][][][] visited = new boolean[n][m][energy + 1][1 << litterCount];

        Queue<State> q = new LinkedList<>();
        q.offer(new State(startR,startC,energy,0,0));

        visited[startR][startC][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            State curr = q.poll();

            // All litter collected
            if (curr.mask == allMask) {
                return curr.moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // Wall
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Need energy to move
                if (curr.energy == 0) {
                    continue;
                }

                int newEnergy = curr.energy - 1;
                int newMask = curr.mask;

                char cell = classroom[nr].charAt(nc);

                // Collect litter
                if (cell == 'L') {
                    int index = litterIndex[nr][nc];

                    newMask |= (1 << index);
                }

                // Restore energy
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Already visited this exact state
                if (visited[nr][nc][newEnergy][newMask]) {
                    continue;
                }

                visited[nr][nc][newEnergy][newMask] = true;

                q.offer(new State(
                    nr,
                    nc,
                    newEnergy,
                    newMask,
                    curr.moves + 1
                ));
            }
        }
        return -1;
    }
}