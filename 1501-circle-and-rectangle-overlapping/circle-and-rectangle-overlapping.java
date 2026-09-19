class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //clamping method
        //1.find nearest x and nearest y
        //2. find euclidean distance 
        //4. check dist <= radius^2 , yes overlap

        int nearX = Math.max(x1,Math.min(xCenter,x2));
        int nearY = Math.max(y1,Math.min(yCenter,y2));

        //euclidean distance
        int disX = xCenter - nearX;
        int disY = yCenter - nearY;

        int Eucl_dist = (disX * disX) + (disY * disY);

        return Eucl_dist <= radius*radius;
    }
}