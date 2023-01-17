class Solution {
    public int minFlipsMonoIncr(String s) {
        int L = s.length();
        int gadbad=0;
        for(int i=0; i<L; i++) {
            if(s.charAt(i)=='0') {
                gadbad++;
            }
        }
        int ans = gadbad;
        for(int i=0; i<L; i++) {
            if(s.charAt(i)=='0') {    
                gadbad--;
            } else {
                gadbad++;
            }
            ans = Math.min(ans, gadbad);
        }
        return ans;
    }
}