class Solution {
    public int countVowelPermutation(int n) {
        int mod = 1000000007;
        long a = 1l;
        long e = 1l;
        long i = 1l;
        long o = 1l;
        long u = 1l;
        
        for(int k=1; k<n; k++) {
            long a_next = e ;
            
            long e_next = (a + i)%mod;
            long i_next = (a + e + o + u)%mod;
            long o_next = (i + u)%mod;
            long u_next = a%mod;
            
            a = a_next;
            e = e_next;
            i = i_next;
            o = o_next;
            u = u_next;
        }
        return (int)((a + e + i + o + u)%mod);
    }
}