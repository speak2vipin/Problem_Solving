class Solution {
    public boolean isValid(String word) {
        boolean isVowel = false;
        boolean isConsonant = false;
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('i'); set.add('o'); set.add('u'); set.add('e');
        set.add('A'); set.add('I'); set.add('O'); set.add('U'); set.add('E');
        
        for(int i=0; i<word.length(); i++) {
            char ascii = word.charAt(i);
            if((ascii>64 && ascii<91) || (ascii>96 && ascii<123)) {
                if(set.contains(ascii)) {
                   isVowel = true; 
                } else {
                   isConsonant = true;
                }
            } else if(!(ascii>47 && ascii<58)) {
                return false;
            }
        }
        return word.length()>2 && isVowel && isConsonant;
    }
}