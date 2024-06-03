class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        while(i<t.length()) {
            while(j<s.length()) {
                if(s.charAt(j)==t.charAt(i)) {
                    j++;
                    i++;
                    break;
                }
                j++;
            }
            if(j>=s.length()) {
                break;
            }
        }
        return t.length() - i;
    }
}