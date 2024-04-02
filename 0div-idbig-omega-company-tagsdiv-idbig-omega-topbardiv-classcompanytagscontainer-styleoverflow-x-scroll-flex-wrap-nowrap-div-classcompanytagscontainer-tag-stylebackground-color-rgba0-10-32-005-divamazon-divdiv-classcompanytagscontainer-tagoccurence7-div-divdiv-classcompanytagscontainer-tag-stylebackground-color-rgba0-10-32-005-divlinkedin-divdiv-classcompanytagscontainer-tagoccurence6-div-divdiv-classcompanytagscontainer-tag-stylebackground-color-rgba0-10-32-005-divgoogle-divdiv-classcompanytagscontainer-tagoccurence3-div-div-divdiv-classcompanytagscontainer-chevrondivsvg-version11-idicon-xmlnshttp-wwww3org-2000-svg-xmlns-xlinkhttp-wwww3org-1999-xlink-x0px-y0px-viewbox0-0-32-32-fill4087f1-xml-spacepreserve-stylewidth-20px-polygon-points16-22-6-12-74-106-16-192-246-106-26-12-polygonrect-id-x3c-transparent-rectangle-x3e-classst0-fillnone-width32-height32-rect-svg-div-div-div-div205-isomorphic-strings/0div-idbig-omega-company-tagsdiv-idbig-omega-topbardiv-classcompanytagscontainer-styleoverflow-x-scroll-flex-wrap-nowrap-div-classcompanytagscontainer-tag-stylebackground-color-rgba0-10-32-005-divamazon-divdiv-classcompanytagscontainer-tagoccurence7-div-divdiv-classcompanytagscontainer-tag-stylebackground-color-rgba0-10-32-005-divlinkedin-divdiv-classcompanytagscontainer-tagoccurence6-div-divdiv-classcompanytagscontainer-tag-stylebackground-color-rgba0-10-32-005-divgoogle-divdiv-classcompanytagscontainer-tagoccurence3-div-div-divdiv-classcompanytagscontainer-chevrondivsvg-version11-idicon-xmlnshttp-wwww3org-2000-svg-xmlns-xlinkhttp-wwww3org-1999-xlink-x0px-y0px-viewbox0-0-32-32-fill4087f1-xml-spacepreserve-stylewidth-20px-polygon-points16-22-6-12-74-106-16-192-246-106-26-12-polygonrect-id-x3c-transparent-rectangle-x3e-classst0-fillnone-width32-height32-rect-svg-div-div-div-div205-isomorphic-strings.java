class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stringMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(stringMap.get(tempS)==null 
               && !stringMap.values().contains(tempT)) {
                stringMap.put(tempS, tempT);
            } else if(stringMap.get(tempS)!=null 
                      && stringMap.get(tempS).equals(tempT)) {
                
            } else {
                return false;
            }
        }
        return true;
        
    }
}