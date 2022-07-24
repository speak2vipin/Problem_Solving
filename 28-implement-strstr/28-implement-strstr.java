class Solution {
    public int strStr(String haystack, String needle) {
        if(needle!=null && needle.length()==0) {
            return 0;
        } else {
            if(haystack.contains(needle)) {
                return haystack.indexOf(needle);
            } else {
                return -1;
            }
        }
        //return -1;
        
    
    }
}