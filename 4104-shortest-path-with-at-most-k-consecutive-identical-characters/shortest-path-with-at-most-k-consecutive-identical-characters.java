import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of [v, w]
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[]{v, w});
        }
        
        // Priority queue stores: [weight, node, count]
        // Ordered by weight ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // dist[node][count] stores the minimum weight to reach node with a specific consecutive count
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Base case: start at node 0 with count 1
        pq.offer(new int[]{0, 0, 1});
        dist[0][1] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];
            
            // If we reached the destination node
            if (u == n - 1) {
                return d;
            }
            
            if (d > dist[u][count]) {
                continue;
            }
            
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                
                int nextCount = 1;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                }
                
                if (nextCount <= k && d + w < dist[v][nextCount]) {
                    dist[v][nextCount] = d + w;
                    pq.offer(new int[]{d + w, v, nextCount});
                }
            }
        }
        
        return -1;
    }
}