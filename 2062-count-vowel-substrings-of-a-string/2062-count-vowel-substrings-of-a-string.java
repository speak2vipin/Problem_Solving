class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> vowelSet = new HashSet<Character>();
        vowelSet.add('a');
         vowelSet.add('i');
         vowelSet.add('o'); vowelSet.add('u');
         vowelSet.add('e');
        int count =0;
        Set<Character> testVowelSet = new HashSet<Character>();
        
        for(int i=0; i<word.length();i++) {
            if(vowelSet.contains(word.charAt(i))) {
                testVowelSet.clear();
                testVowelSet.add(word.charAt(i));
                for(int j = i+1; j<word.length();j++) {
                    if(vowelSet.contains(word.charAt(j))) {
                         testVowelSet.add(word.charAt(j));
                        if(testVowelSet.size()==5) {
                           count++;
                            //break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                continue;
            }
        }
        return count;
    }
}