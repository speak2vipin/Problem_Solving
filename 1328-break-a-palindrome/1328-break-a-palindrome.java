class Solution {
    public String breakPalindrome(String palindrome) {
        String ans = "";
        int i = 0;
        int j = palindrome.length()-1;
        if(j==0) {
            return ans;
        }
        
        char temp = '\u0000';
        int index = -1;
        while(i<j) {
            temp = palindrome.charAt(i);
            if(temp != 'a') {
               index = i;
                break;
            }
            i++;
            j--;
        }
        if(index==-1) {
            ans = palindrome.substring(0,palindrome.length()-1) + 'b';
        } else {
            ans = palindrome.substring(0, index) + 'a' + palindrome.substring(index+1);
        }
        return ans;
    }
}