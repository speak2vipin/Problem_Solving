class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int minDist = 0;
        for(int i=1; i<n; i++) {
            int dx = Math.abs(points[i][0] - points[i-1][0]);
            int dy = Math.abs(points[i][1] - points[i-1][1]);
            if(dx==0) {
                minDist += dy;
            } else if(dy==0) {
                minDist += dx;
            } else if(Math.abs(dx)==Math.abs(dy)) {
                minDist += dx;
            } else {
                int max = Math.max(dx,dy);
                minDist += max;
            }
        }
        return minDist;
    }
}