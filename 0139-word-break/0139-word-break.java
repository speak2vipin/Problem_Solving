class Solution {
    //boolean status = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> status = new HashMap<>();
        return helper(s, wordSet, status);
        //return status;
    }
    
    boolean helper(String s,  Set<String>wordSet, Map<String, Boolean> status) {
        if(wordSet.contains(s)) {
            return true;
        }
        if(status.get(s)!=null) {
            return status.get(s);
        }
      //  if(index==s.length()) {
        //    status = true;
          //  return;
        //}
        
        for(int i=1; i<=s.length(); i++) {
            String st = s.substring(0,i);
            if(wordSet.contains(st) && helper(s.substring(i), wordSet, status)) {
                status.put(st, true);
                return true;
            }
        }
        status.put(s, false);
        return false;
        
    }
}