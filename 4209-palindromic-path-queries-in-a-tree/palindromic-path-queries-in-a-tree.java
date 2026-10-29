import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[][] up;
    int[] tin, tout, depth, parent, size;
    int timer, LOG;
    Fenwick bit;
    char[] s;

    class Fenwick {
        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            while (i < tree.length) {
                tree[i] ^= val;
                i += i & -i;
            }
        }

        void rangeUpdate(int l, int r, int val) {
            update(l, val);
            update(r + 1, val);
        }

        int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans ^= tree[i];
                i -= i & -i;
            }
            return ans;
        }
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String str, String[] queries) {

        s = str.toCharArray();
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        size = new int[n];
        Arrays.fill(parent, -1);

        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        timer = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = ++timer;
            order[timer - 1] = u;

            up[0][u] = parent[u];

            for (int j = 1; j < LOG; j++)
                up[j][u] = up[j - 1][up[j - 1][u]];

            for (int v : adj[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        Arrays.fill(size, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int i = 0; i < n; i++)
            tout[i] = tin[i] + size[i] - 1;

        bit = new Fenwick(n);

        for (int u = 0; u < n; u++) {
            int mask = 1 << (s[u] - 'a');
            bit.rangeUpdate(tin[u], tout[u], mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            int u = Integer.parseInt(p[1]);

            if (p[0].equals("update")) {
                char c = p[2].charAt(0);

                int delta = (1 << (s[u] - 'a'))
                          ^ (1 << (c - 'a'));

                bit.rangeUpdate(tin[u], tout[u], delta);
                s[u] = c;

            } else {
                int v = Integer.parseInt(p[2]);
                int lca = getLCA(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (s[lca] - 'a'));

                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++)
            if ((diff & (1 << j)) != 0)
                u = up[j][u];

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return parent[u];
    }
}