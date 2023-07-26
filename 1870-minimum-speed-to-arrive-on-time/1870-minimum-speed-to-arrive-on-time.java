class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
       
        return helper(dist, hour);
        
    }
    
    public int helper(int dist[], double hour) {
        int st = 0;
        int en = 10000000;
        int res = -1;
        while(st<=en) {
            int mid = en - (en-st)/2;
            if(isFeasible(dist, mid, hour)) {
                res = mid;
                en = mid-1;
            } else {
                st = mid+1;
            }
        }
        return res;
    }
    
    boolean isFeasible(int dist[], int speed, double hour) {
        double consumeHour = 0;
        int n = dist.length;
        for(int i=0; i<n; i++) {
            double t = (double)dist[i]/(double) speed;
            consumeHour += (i==n-1 ? t : Math.ceil(t));
        }
        return hour>=consumeHour;
    }
}