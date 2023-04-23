class Solution {
    // Logic: 
    // It's all about we can split our String having number within the the range i.e. 1 to k
    // Take care of st==s.length() -> return 1 (As we can split an empty String for 1 time)
    // if(st==s.length()) { return 1}
    
    int dp[] = null;
    int mod = 1000_000_007;
    
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        dp = new int[m+1];
        return process(s, 0, k);
    }
    
    int process(String s, int st, int k) {
        if(dp[st] != 0) {
            return dp[st];
        }    
        // In how many ways we can split an empty String
        if(st == s.length()) {
            return 1;
        }
        // Numbers preceeding with 0 are invalid
        if(s.charAt(st)=='0') {
            return 0;
        }
        int count = 0;
        for(int end = st; end<s.length(); end++) {
            String number = s.substring(st, end+1);
            // If number is greater than k, it's invalid
            if(Long.parseLong(number)>k) {
                break;
            }
            // It about processing 12345 --> 2345
            count = (count + process(s, end+1, k))%mod;
        }
        dp[st] = count;
        return dp[st];
    }
    
}