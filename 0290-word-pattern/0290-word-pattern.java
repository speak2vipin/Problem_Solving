class Solution {
    public boolean wordPattern(String pattern, String s) {      
        Map<String, Character> map = new HashMap();
        String words[] = s.split(" ");
        int l = words.length;
        if(l!=pattern.length()) {
            return false;
        }
        for(int i=0; i<l; i++) {
            String temp = words[i];
            char tempChar = pattern.charAt(i);
            if(map.get(temp) == null) {
                if(map.values().contains(tempChar)) {
                    return false;
                }
                map.put(temp,tempChar);
            } else {
                if(map.get(temp) == tempChar) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}