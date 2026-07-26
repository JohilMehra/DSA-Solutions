class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //1.create n*n matrix for storing distance
        int dist[][] = new int[n][n];
        //fill cells with infinite : in case route is not availble
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int e[] : edges){
            int u=e[0],v=e[1],wt=e[2];
            // bi-directional edges
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        
        //2.diagonal distance be 0 like dist from 0 -> 0 = 0
        for(int i=0;i<n;i++) dist[i][i]=0;

        //3.now perform floyd_warshall algorithm
        //try with every city via and reach other city with min distance
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //only if it is possible/minimum then infinity
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int cntCity=n; //initialize with max no of cities &we have to find minimum
        int cityNo=-1; //stores starting point/city

        for(int city=0;city<n;city++){
            //make every city as starting pnt one by one 
            int cnt=0;
            for(int adjCity=0; adjCity<n; adjCity++){
                //if it dist <= thresold then cnt++
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }

            if(cnt <= cntCity){
                //if found min
                cntCity = cnt;
                cityNo = city;//if two cities have min values then take the highest city number that is why cnt <= cntCity ,it stores the greater city
            }
        }
        return cityNo;
    }
}