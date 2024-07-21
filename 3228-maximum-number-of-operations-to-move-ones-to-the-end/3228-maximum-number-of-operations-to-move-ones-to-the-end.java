class Solution {
    public int maxOperations(String s) {
        int count = 0;
        int i = 0;
        int one = 0;
        while(i<s.length()) {
            int j = i+1;
            if(s.charAt(i)=='1') {
                one++;
                int zero = 0;
                while(j<s.length() &&  s.charAt(j)=='0') {
                    j++;
                    zero++;
                }
                if(zero>0) {
                    count += one;
                }
            }
            i = j;
        }
        return count;
    }
}