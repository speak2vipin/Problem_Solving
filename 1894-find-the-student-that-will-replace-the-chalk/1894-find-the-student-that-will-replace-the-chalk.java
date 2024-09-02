class Solution {
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
    }
}