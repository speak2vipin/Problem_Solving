class Solution {
    public int numSub(String s) {
        long count = 0;
        int mod = 1000_000_007;
        int N = s.length();
        int i = 0;
        int j = 0;;
        while(i<N) {
            if(s.charAt(i)=='1') {
                j = i;
                while(j<N) {
                    if(s.charAt(j)=='1') {
                        j++;
                    } else {
                        break;
                    }  
                }
                j--;
                int len = j-i+1;
                count = count + ((1l* (len)) * (len+1)/2)%mod;
                i = j;
            }
            i++;
        }
        return (int)count;
    }
}