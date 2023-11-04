class Solution {
    public int getLastMoment(int N, int[] left, int[] right) {
        
        
        if(left==null || left.length==0) {
            int min = right[0];
            for(int r : right) {
                min = Math.min(r, min);
            }
            return N-min;
        }
        if(right==null || right.length==0) {
            int max = left[0];
            for(int l : left) {
                max = Math.max(l, max);
            }
            return max;
        }
        int ans = Integer.MIN_VALUE;
        int m = left.length;
        int n = right.length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(right[j]>left[i]) {
                    ans = Math.max(ans, Math.max(left[i], N-right[j]));
                } else {
                    ans = Math.max(ans, left[i]-right[j] + Math.max(N-left[i], right[j]-0));
                }
            }
        }
        return ans;
    }
}