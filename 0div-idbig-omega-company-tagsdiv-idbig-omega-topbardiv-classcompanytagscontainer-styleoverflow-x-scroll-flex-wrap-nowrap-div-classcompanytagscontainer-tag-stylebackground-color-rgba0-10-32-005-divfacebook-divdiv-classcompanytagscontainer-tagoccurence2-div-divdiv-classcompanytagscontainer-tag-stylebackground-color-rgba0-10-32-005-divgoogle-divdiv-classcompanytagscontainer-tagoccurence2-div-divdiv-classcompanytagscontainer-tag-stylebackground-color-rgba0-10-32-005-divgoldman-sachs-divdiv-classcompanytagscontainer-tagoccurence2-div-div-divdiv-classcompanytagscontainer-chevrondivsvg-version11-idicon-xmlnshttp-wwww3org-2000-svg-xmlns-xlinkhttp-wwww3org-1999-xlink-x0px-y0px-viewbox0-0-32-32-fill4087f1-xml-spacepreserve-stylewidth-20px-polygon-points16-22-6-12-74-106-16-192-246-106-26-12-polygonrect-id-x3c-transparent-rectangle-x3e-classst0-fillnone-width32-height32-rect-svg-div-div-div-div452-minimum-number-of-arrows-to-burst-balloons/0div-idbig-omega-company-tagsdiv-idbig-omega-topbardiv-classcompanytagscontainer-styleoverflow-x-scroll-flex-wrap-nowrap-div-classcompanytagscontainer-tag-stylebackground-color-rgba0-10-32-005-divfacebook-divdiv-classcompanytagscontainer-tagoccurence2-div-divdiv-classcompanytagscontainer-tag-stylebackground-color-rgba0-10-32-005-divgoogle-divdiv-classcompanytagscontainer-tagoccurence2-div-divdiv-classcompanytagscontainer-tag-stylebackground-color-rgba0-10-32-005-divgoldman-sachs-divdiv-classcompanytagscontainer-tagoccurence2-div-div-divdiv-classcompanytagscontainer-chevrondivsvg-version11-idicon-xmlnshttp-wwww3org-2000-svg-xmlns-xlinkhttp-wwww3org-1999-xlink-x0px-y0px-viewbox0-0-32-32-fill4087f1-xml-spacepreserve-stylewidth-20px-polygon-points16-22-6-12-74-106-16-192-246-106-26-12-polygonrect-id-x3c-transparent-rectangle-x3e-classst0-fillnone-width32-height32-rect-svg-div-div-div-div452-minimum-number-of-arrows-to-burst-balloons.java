class Solution {
    public int findMinArrowShots(int[][] points) {
        //Arrays.sort(points, (x, y)->x[1]-y[1]);
        Arrays.sort(points, (x, y)->Integer.compare(x[1], y[1]));
        int arrows = 1;
       // int st = points[0][0];
        //int en = points[0][1];
        int n = points.length;
        int window[] = points[0];
        for(int i=1; i<n; i++) {
            if(isOverlapped(window, points[i])) {
                window[0]  = Math.max(window[0], points[i][0]);
                window[1]  = Math.min(window[1], points[i][1]);
            } else {
                arrows++;
                window = points[i];
            }
        }
        return arrows;
    }
    
    boolean isOverlapped(int p1[], int p2[]) {
       // return (Math.min(p1[1], p2[1]) - Math.max(p1[0], p2[0])) >= 0;
        return p2[0] <= p1[1];
    }
}