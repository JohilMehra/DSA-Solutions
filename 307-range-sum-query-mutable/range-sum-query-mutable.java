class NumArray {
    int[] tree;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        this.n=nums.length;
        this.nums=nums;
        tree=new int[4*n];

        build(0,0,n-1);
    }
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            nums[idx] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node + 1, start, mid, idx, val);
        else
            update(2 * node + 2, mid + 1, end, idx, val);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
    private int query(int node, int start, int end, int l, int r) {
        // no overlap
        if (r < start || end < l) return 0;

        // full overlap
        if (l <= start && end <= r) return tree[node];

        // partial overlap
        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r) +
               query(2 * node + 2, mid + 1, end, l, r);
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */