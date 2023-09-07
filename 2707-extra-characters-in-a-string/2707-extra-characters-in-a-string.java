class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean isWord = false;
}

class Solution {
    Set<String> dictionarySet = null;
    Integer dp[] = null;
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        dp = new Integer[n];
        return helper(0, n, s);
    }

    int helper(int start, int n, String s) {
        if(start==n) {
            return 0;
        }
        if(dp[start]!=null) {
            return dp[start];
        }
        int ans = 1 + helper(start+1, n, s);
        for(int end=start; end<n; end++) {
            String sub = s.substring(start, end+1);
            if(dictionarySet.contains(sub)) {
                ans = Math.min(ans, helper(end+1, n, s));
            }
        }
        return dp[start] = ans;
    }
}