import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by end time, then start time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // prev[i] = last interval whose end < current start
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        // long is required because total weight can exceed int range
        long[][] dp = new long[n + 1][5];

        // selected[i][k] = lexicographically smallest indices
        // producing dp[i][k]
        List<Integer>[][] selected =
                new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                selected[i][k] = new ArrayList<>();
            }
        }

        // DP
        for (int i = 1; i <= n; i++) {

            int curr = i - 1;

            for (int k = 1; k <= 4; k++) {

                // Option 1: Skip current interval
                long skip = dp[i - 1][k];

                // Option 2: Take current interval
                int p = prev[curr];

                long take = (long) arr[curr][2]
                        + dp[p + 1][k - 1];

                if (take > skip) {

                    dp[i][k] = take;

                    selected[i][k] =
                            new ArrayList<>(selected[p + 1][k - 1]);

                    selected[i][k].add(arr[curr][3]);

                    Collections.sort(selected[i][k]);

                } else if (take < skip) {

                    dp[i][k] = skip;

                    selected[i][k] =
                            new ArrayList<>(selected[i - 1][k]);

                } else {

                    // Same weight:
                    // choose lexicographically smaller indices

                    List<Integer> takeList =
                            new ArrayList<>(selected[p + 1][k - 1]);

                    takeList.add(arr[curr][3]);

                    Collections.sort(takeList);

                    List<Integer> skipList =
                            selected[i - 1][k];

                    if (isLexicographicallySmaller(
                            takeList, skipList)) {

                        dp[i][k] = take;
                        selected[i][k] = takeList;

                    } else {

                        dp[i][k] = skip;
                        selected[i][k] =
                                new ArrayList<>(skipList);
                    }
                }
            }
        }

        // We can select at most 4 intervals
        List<Integer> answer = selected[n][4];

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // Find the last interval j before i such that:
    // arr[j].end < arr[i].start
    private int findPrevious(int[][] arr, int i) {

        int low = 0;
        int high = i - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][1] < arr[i][0]) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Returns true if a is lexicographically smaller than b
    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is a prefix of the other,
        // shorter list is lexicographically smaller
        return a.size() < b.size();
    }
}