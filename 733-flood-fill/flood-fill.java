class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor=image[sr][sc];

        if(startingColor==color) return image;

        int m=image.length;
        int n=image[0].length;
        
        dfstraversal(image,sr,sc,color,startingColor,m,n);

        return image;
    }

    public static void dfstraversal(int[][] image,int sr,int sc,int color,int startingColor,int m,int n){
        image[sr][sc]=color;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] d:dir){
            int nr=sr+d[0];
            int nc=sc+d[1];

            if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==startingColor){
                dfstraversal(image,nr,nc,color,startingColor,m,n);
            }
        }
    }
}