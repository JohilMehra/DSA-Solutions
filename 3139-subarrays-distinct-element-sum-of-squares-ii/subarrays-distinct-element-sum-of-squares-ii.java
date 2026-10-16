
class Solution {
    private static final long MOD = 1_000_000_007L;

    private int n;
    private long[] sum;
    private long[] squareSum;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        squareSum = new long[4 * n];
        lazy = new long[4 * n];

        int[] lastSeen = new int[100001];
        java.util.Arrays.fill(lastSeen, -1);

        long answer = 0;

        for (int r = 0; r < n; r++) {
            int previous = lastSeen[nums[r]];

            // All subarrays starting in this range
            // gain one new distinct element.
            update(1, 0, n - 1, previous + 1, r);

            lastSeen[nums[r]] = r;

            // Sum of squared distinct counts for
            // all subarrays ending at index r.
            answer = (answer + squareSum[1]) % MOD;
        }

        return (int) answer;
    }

    private void push(int node, int start, int end) {
        long add = lazy[node];

        if (add == 0) {
            return;
        }

        long len = end - start + 1L;

        // (x + add)^2 = x^2 + 2*x*add + add^2
        squareSum[node] =
            (squareSum[node]
                + 2L * add * sum[node]
                + add * add % MOD * len % MOD) % MOD;

        sum[node] = (sum[node] + add * len) % MOD;

        if (start != end) {
            lazy[node * 2] += add;
            lazy[node * 2 + 1] += add;
        }

        lazy[node] = 0;
    }

    private void update(
        int node, int start, int end, int left, int right
    ) {
        push(node, start, end);

        if (end < left || start > right) {
            return;
        }

        if (left <= start && end <= right) {
            lazy[node] += 1;
            push(node, start, end);
            return;
        }

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);

        sum[node] =
            (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        squareSum[node] =
            (squareSum[node * 2] + squareSum[node * 2 + 1]) % MOD;
    }
}
