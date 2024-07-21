class Solution {
    
//If the number of vowels is 0, Bob wins because Alice has no vowels to pick.
//If the number of vowels is odd, Alice can pick all of them on her turn. In this case, Bob will //have no vowels left to pick on his turn, resulting in Bob losing.
//If the number of vowels is even, say n, Alice can pick n - 1 vowels on her turn, leaving exactly //1 vowel (which is odd) for Bob. Bob will then be unable to pick any more vowels on his turn, //resulting in Bob losing.
//Therefore, if the count of vowels is greater than 0, Alice will win; otherwise, Bob will win.
    
    public boolean doesAliceWin(String s) {
        
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
       
        for(int i=0; i< s.length(); i++) {
            if(vowels.contains(s.charAt(i))) {
                return true;
            }
        }
        return false;     
    }
}