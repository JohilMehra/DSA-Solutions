class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int length = n + m - 1;

        // Valid parentheses string must have even length
        if (length % 2 != 0) {
            return false;
        }

        // First character must be '('
        if (grid[0][0] != '(') {
            return false;
        }

        // Last character must be ')'
        if (grid[n - 1][m - 1] != ')') {
            return false;
        }

        boolean dp[][][] = new boolean[n][m][length + 1];

        // Starting cell
        dp[0][0][1] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int change = grid[i][j] == '(' ? 1 : -1;

                for (int bal = 0; bal <= length; bal++) {

                    int prevbal = bal - change;

                    // IMPORTANT: prevent array index out of bounds
                    if (prevbal < 0 || prevbal > length) {
                        continue;
                    }

                    // Come from top
                    if (i > 0 && dp[i - 1][j][prevbal]) {
                        dp[i][j][bal] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][prevbal]) {
                        dp[i][j][bal] = true;
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}