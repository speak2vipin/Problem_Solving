class Solution {
    public boolean detectCapitalUse(String word) {
        int L = word.length();
        if(L==1) {
            return true;
        }
        boolean firstSmallLetter = ((word.charAt(0)>>5) & 1) == 1;
        boolean secondSmallLetter = ((word.charAt(1)>>5) & 1) == 1;
        // Fisrt lowercase but second uppercase
        if(firstSmallLetter && !secondSmallLetter) {
            return false;
        }
        for(int i=2; i<L; i++) {
            // All are lowercase only
            if(firstSmallLetter && secondSmallLetter 
               && ((word.charAt(i)>>5) & 1) == 1) {
                continue;
            } 
            // First uppercase and rest lowercase
            else if(!firstSmallLetter && secondSmallLetter 
                      && ((word.charAt(i)>>5) & 1) == 1 ) {
                continue;
            } 
            // All are uppercase
            else if(!firstSmallLetter && !secondSmallLetter 
                      && !(((word.charAt(i)>>5) & 1) == 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}