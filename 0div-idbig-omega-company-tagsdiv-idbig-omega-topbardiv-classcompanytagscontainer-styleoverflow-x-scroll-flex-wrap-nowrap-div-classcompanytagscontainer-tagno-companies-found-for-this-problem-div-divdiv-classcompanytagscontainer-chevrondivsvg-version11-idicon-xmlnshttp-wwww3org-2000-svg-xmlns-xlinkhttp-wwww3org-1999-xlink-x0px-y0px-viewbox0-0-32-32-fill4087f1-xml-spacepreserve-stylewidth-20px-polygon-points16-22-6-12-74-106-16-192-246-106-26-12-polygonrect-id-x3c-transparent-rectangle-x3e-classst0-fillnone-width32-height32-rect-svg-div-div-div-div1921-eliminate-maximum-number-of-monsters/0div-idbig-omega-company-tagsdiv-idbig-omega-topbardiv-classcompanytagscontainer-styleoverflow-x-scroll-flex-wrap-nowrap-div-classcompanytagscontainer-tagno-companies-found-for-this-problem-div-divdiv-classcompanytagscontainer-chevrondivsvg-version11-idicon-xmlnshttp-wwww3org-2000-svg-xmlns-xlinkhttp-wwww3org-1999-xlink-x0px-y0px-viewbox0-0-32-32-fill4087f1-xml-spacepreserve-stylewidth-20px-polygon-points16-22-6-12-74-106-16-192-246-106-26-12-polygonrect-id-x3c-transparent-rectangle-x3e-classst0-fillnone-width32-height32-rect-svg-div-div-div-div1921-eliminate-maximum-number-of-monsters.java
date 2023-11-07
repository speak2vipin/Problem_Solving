class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        float time[] = new float[n];
        for(int i=0; i<n; i++) {
            if(speed[i]==0) {
                return 0;
            }
            time[i] = (float)dist[i]/(float)speed[i];
            
        }
       Arrays.sort(time);
        int count = 0;
       for(int i=0; i<n; i++) {
           if(time[i]-i>0) {
               count++;
           } else {
               break;
           }
           
       }
        return count;
        
    }
}