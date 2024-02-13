class Solution {
    public String firstPalindrome(String[] words) {
        String ans = "";
        for(String word : words) {
            if(isPalindrome(word)) {
                ans = word;
                break;
            }
        }
        return ans;
    }
    
    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}