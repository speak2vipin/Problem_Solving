class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double time[] = new double[n];
        for(int i=0; i<n; i++) {
            if(speed[i]==0) {
                return 0;
            }
            time[i] = (double)dist[i]/(double)speed[i];
        }
       Arrays.sort(time);
        
        int count = 0;
       for(int i=0; i<n; i++) {
           // Arrival time should be greater than current time
           if(time[i]>i) {
               count++;
           } else {
               break;
           }
       }
        return count;
    }
}