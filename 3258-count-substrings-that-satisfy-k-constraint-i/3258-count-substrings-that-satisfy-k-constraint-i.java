class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int one = 0;
        int zero = 0;
        int i=0, j=0;
        int len = 0;
        while(j<n) {
            if(s.charAt(j)=='0') {
                zero++;
            } else {
                one++;
            }
            while(i<=j && zero>k && one>k) {
                if(s.charAt(i)=='0') {
                    zero--;
                } else {
                    one--;
                }
                i++;
            }
            len += zero+one;
            j++;
        }
        return len;
    }
}

