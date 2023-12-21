class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x,y)->x[0]-y[0]);
        int n = points.length;
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            ans = Math.max(ans, points[i][0] - points[i-1][0]);
        }
        return ans;
    }
}