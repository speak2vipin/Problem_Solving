class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int result[][] = new int[n][];
        List<int[]>ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(isOverlapped(intervals[i], newInterval)) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        ans.add(newInterval);
        Collections.sort(ans, (x,y)->x[0]-y[0]);
        result = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++) {
        	result[i] = ans.get(i);
        }
        return result;  
    }
    
    boolean isOverlapped(int interval1[], int interval2[]) {
        return (Math.min(interval2[1], interval1[1]) 
                - Math.max(interval2[0], interval1[0])) >= 0;
    }
}