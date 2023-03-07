class Solution {
    
    boolean isPossible(int[]time, long givenTime, int trips) {
		long actualTrips = 0;
		for(int x : time) {
			actualTrips += givenTime/x;
		}
		return actualTrips>=trips;
	}
    
	public long minimumTime(int[] time, int totalTrips) {

        int maxTime = time[0];
        for(int x : time) {
            maxTime = Math.max(maxTime, x);
        }
        long low = 1;
        long high = ((long)maxTime)*totalTrips;
        long mid = 0;
        while(low<high) {
        	mid = low + (high-low)/2;
        	if(isPossible(time, mid, totalTrips)) {
        		high = mid;
        	} else {
        		low = mid+1;
        	}
        }
        return (long)low;
    }
}