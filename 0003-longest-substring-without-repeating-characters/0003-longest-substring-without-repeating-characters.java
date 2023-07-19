class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> unique = new HashSet<>();
        int i=0;
        int j=0;
        int l = s.length();
        int res = 0;
        while(i<l) {
            char temp = s.charAt(i);
            while(unique.contains(temp)) {
                unique.remove(s.charAt(j));
                j++;
            }
            unique.add(temp);
            
            res = Math.max(res, i-j+1);
            i++;
        }
        return res;
    }
}