class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
		intervals = insertInterval(intervals, newInterval);
		List<int[]> ans = new ArrayList<int[]>();
		for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = {intervals[i][0], intervals[i][1]};
            while(i<intervals.length && doesIntervalsOverlap(currInterval, intervals[i])) {
            	currInterval = mergeInterval(currInterval, intervals[i]);
            	i++;
            }
            i--;
            ans.add(currInterval);
		}
		return ans.toArray(new int[ans.size()][2]);
		
	}
	 
	    
	  int[][] insertInterval(int[][] intervals, int[] newInterval) {
	        boolean isIntervalInserted = false;
	        List<int[]>list = new ArrayList<>(Arrays.asList(intervals));
	        for(int i=0; i<intervals.length; i++) {
	        	if(newInterval[0] < intervals[i][0]) {
	        		list.add(i, newInterval);
	        		isIntervalInserted = true;
	        		break;
	        	}
	        }
	        if(!isIntervalInserted) {
	        	list.add(newInterval);
	        }
	        return list.toArray(new int[list.size()][2]);
	        
	    }
	    
	    boolean doesIntervalsOverlap(int a[], int b[]) {
	    	return Math.min(a[1],b[1]) - Math.max(a[0], b[0]) >= 0;
	    }
	    
	    int[]mergeInterval(int []a, int []b) {
	    	int[]mergedInterval = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
	    	return mergedInterval;
	    }
}