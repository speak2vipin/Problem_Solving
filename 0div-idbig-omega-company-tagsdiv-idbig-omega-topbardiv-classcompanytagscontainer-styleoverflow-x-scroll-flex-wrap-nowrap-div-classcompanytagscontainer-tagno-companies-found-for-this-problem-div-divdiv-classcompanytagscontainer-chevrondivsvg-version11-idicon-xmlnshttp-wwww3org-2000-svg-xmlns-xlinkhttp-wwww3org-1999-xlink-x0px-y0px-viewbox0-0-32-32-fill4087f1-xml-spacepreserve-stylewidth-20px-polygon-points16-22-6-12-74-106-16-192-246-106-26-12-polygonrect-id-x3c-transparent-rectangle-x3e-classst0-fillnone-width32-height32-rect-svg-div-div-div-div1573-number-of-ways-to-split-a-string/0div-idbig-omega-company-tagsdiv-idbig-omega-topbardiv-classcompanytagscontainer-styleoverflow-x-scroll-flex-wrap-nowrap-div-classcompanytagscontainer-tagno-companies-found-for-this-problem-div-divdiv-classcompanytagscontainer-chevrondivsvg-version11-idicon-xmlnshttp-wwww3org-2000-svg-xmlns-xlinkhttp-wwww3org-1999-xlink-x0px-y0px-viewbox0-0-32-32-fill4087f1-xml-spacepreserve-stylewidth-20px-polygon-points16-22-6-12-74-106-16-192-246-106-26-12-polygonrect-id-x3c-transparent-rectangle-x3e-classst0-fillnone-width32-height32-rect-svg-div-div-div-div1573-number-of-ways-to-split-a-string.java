class Solution {
    public int numWays(String s) {
        long n = (long)s.length();
        long mod = 1000_000_007;
        long ones = 0l;
        for(char c : s.toCharArray()) {
            if(c=='1') {
                ones++;
            }
        }
        if(ones==0) {
            return (int)((((n-1)*(n-2))/2)%mod);
        } else if(ones%3!=0) {
            return 0;
        } else {
            long oneCount = 0l;
            long setone = 0l;
            long settwo = 0l;
            for(char c : s.toCharArray()) {
                if(c=='1') {
                    oneCount++;
                }
                if(oneCount==ones/3) {
                    setone++;
                }
                if(oneCount==(2*ones)/3) {
                    settwo++;
                }
            }
            return (int)((setone * settwo)%mod);
        }
        
    }
}