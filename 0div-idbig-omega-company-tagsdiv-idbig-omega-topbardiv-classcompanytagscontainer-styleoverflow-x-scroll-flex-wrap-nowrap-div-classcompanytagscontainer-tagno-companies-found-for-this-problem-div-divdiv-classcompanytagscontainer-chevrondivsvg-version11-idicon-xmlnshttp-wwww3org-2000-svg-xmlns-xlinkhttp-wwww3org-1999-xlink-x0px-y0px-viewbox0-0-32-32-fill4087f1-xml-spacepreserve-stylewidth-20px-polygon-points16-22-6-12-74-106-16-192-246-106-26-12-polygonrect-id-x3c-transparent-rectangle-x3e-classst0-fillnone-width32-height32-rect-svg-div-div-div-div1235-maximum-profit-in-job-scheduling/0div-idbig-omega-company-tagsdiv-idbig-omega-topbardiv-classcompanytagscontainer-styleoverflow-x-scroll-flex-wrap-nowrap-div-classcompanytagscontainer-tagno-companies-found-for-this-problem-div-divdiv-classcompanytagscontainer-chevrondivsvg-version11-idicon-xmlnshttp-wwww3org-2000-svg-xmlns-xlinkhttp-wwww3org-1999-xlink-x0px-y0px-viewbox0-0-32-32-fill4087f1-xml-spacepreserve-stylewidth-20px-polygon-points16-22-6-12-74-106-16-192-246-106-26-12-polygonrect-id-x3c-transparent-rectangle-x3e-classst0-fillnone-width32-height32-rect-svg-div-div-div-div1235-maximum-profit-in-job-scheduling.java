class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int jobs[][] = new int[n][3];
        for(int i=0; i<n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (x,y)->x[1]-y[1]);
        TreeMap<Integer, Integer> dp  = new TreeMap<>();
        dp.put(0, 0);
        for(int i=0; i<n; i++) {
            int val = jobs[i][2] + dp.floorEntry(jobs[i][0]).getValue(); 
            if(val>dp.lastEntry().getValue()) {
                dp.put(jobs[i][1], val);
            }
        }
        return dp.lastEntry().getValue();
    }
}