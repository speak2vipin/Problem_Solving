class Solution {
    public int lengthOfLastWord(String s) {
        String sArray[] = s.split(" ");
        return sArray[sArray.length-1].length();
        
    }
}