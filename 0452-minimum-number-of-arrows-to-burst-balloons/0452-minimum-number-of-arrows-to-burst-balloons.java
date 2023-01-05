class Solution {
    public int findMinArrowShots(int[][] points) {
        // Interval Overlapping Pattern
        // This was giving error as numbers were not converting to 32 bit explicitly
        //Arrays.sort(points, (a,b)-> a[1]-b[1]);
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int N = points.length;
        int shootPoint = points[0][1];
        int count = 1;
        for(int point[] : points) {
            if(point[0]<=shootPoint) {
                continue;
            } else {
                shootPoint = point[1];
                count++;
            }
        }
        return count;
    }
}