class Solution {
    public int countVowelSubstrings(String word) {
        /*Set<Character> vowelSet = new HashSet<Character>();
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
        return count;*/
        
        
        int vow = 0;
        int n = word.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < n-4; i++)
        {
            set.clear();
            for(int j = i; j < n; j++)
            {
                char ch = word.charAt(j);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    set.add(ch);
                    if(set.size() == 5)
                        vow++;
                }
                else
                    break;
            }
        }
        return vow;
    
    }
}