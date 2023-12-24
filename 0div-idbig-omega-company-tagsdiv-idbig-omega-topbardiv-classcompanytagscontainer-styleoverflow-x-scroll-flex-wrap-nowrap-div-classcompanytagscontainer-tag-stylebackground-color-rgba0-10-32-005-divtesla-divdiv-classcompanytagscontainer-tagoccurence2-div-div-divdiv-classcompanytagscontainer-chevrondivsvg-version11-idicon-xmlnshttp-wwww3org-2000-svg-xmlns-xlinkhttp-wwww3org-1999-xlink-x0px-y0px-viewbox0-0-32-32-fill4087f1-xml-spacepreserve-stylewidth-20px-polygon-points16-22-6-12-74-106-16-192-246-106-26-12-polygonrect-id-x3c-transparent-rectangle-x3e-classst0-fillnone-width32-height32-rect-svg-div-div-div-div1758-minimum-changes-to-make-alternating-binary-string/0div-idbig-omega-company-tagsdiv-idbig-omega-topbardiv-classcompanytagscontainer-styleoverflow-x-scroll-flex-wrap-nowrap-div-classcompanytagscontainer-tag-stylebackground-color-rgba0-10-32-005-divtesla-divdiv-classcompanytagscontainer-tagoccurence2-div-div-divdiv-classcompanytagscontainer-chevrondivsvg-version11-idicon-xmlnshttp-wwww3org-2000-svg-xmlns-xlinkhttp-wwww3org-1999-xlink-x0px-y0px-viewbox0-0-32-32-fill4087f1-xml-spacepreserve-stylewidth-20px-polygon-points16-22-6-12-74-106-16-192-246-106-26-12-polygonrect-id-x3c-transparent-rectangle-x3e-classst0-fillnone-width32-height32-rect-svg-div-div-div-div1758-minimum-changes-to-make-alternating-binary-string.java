class Solution {
    public int minOperations(String s) {
        int ans = 0;
        int n = s.length();
        boolean flag = false;
        char sArray[] = s.toCharArray();
        int start1 = 0;
        int start0 = 0;
        for(int i=0; i<n; i++) {
            if(i%2==0) {
                if(s.charAt(i)=='0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if(s.charAt(i)=='1') {
                    start1++; 
                } else {
                   start0++;
                }
            }
        }
        return Math.min(start1, start0);
        
    }
}