class Solution {
    Map<String, Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        int N = s1.length();
        
        if(s2.length()!=N) {
            return false;
        }
        
        if(s1.equals(s2)) {
            return true;
        }
        
        if(N==1) {
            return false;
        }
        
        String key = s1 + " " + s2;
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        for(int i=1; i<N; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0,i)) && 
               isScramble(s1.substring(i), s2.substring(i))) {
                map.put(key, true);
                return true;
            } 
            if(isScramble(s1.substring(0, i), s2.substring(N-i)) && 
               isScramble(s1.substring(i), s2.substring(0,N-i))) {
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}