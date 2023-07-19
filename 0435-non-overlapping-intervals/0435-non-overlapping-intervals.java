class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        
        int initial[] = intervals[0];
        
        int count = 0;
        for(int i=1; i<intervals.length; i++) {
            int temp[] = intervals[i];
            if(isOverlap(initial, temp)) {
                count++;
            } else {
                initial = temp; 
            }    
        }
        return count;
        
    }
	
	boolean isOverlap(int x[], int y[]) {
		return Math.min(x[1], y[1]) - Math.max(x[0],y[0])>0;
	}
}