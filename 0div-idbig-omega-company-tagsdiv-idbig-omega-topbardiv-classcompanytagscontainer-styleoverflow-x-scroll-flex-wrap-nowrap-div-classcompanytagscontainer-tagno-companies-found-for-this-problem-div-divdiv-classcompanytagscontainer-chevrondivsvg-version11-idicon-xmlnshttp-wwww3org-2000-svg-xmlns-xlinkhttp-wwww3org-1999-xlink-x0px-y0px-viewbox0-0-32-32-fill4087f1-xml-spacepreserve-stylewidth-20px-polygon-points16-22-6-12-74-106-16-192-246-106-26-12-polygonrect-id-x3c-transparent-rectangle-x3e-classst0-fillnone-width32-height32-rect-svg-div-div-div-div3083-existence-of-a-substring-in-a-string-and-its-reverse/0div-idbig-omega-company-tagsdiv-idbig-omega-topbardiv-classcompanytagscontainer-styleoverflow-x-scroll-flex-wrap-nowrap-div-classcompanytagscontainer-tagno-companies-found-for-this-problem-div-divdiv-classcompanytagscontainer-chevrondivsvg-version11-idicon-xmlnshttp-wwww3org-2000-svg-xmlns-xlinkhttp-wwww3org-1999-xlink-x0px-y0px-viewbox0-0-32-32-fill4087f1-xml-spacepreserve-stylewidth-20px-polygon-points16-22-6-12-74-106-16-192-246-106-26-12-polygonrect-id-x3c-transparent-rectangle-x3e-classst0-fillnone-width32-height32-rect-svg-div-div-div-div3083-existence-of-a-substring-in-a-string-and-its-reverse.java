class Solution {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        for(int i=1; i<n; i++) {
            if(s.charAt(i)==s.charAt(i-1) || (i+1<n && s.charAt(i-1)==s.charAt(i+1))) {
                return true;
            }
        }
        return false;
    }
}