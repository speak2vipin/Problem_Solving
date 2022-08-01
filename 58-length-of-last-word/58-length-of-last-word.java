class Solution {
    public int lengthOfLastWord(String s) {
        String []sParts = s.split(" ");
        return sParts[sParts.length-1].length();
        
    }
}