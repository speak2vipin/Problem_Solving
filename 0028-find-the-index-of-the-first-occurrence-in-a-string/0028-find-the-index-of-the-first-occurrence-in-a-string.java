class Solution {
    public int strStr(String haystack, String needle) {
        int L = haystack.length();
        char first = needle.charAt(0);
        int N = needle.length();
        for(int i=0; i<L; i++) {
            if(haystack.charAt(i)==first ) {
                if(i+N <=L && haystack.substring(i, i+N).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}