class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int count = 0;
        int prefix[] = new int[n];
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='0') {
                count++;
                if(i==0) {
                   prefix[i] = 1; 
                } else {
                    prefix[i] = prefix[i-1] + 1;
                }
            } else if(i>0) {
                prefix[i] = prefix[i-1];
            }
        }
       
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++) {
            ans = Math.max(ans, prefix[i] + n - count - (i+1 - prefix[i]));
        }
        return ans;
    }
}