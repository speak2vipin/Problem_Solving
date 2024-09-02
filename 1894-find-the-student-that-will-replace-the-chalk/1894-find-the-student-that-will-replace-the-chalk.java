class Solution {
    /*
    public int chalkReplacer(int[] chalk, int k) {
        
        int n = chalk.length;
        int t = k;
        int ans = -1;
        
        for(int i=0; i<n; i++) {
            if(chalk[i]>t) {
                ans = i;
                break;
            }
            t = t-chalk[i];
        }
        
        if(ans!=-1) {
            return ans;
        }
        
        int sum = k - t;
        k = k%sum;
        
        for(int i=0; i<n; i++) {
            if(chalk[i]>k) {
                return i;
            }
            k = k-chalk[i];
        }
        return -1;
    }*/
    
     public int chalkReplacer(int[] chalk, int k) {
         
         int n = chalk.length;
         long prefix[] = new long[n];
         prefix[0] = chalk[0];
         
         for(int i=1; i<n; i++) {
             prefix[i] = (prefix[i-1] + chalk[i]);
         }
         long sum = k%prefix[n-1];
         int l = 0;
         int r = n-1;
         while(l<r) {
             int m = (r+l)/2;
             if(prefix[m]<=sum) {
                 l = m+1;
             } else {
                 r = m;
             }
         }
         return r;
         
     }
}