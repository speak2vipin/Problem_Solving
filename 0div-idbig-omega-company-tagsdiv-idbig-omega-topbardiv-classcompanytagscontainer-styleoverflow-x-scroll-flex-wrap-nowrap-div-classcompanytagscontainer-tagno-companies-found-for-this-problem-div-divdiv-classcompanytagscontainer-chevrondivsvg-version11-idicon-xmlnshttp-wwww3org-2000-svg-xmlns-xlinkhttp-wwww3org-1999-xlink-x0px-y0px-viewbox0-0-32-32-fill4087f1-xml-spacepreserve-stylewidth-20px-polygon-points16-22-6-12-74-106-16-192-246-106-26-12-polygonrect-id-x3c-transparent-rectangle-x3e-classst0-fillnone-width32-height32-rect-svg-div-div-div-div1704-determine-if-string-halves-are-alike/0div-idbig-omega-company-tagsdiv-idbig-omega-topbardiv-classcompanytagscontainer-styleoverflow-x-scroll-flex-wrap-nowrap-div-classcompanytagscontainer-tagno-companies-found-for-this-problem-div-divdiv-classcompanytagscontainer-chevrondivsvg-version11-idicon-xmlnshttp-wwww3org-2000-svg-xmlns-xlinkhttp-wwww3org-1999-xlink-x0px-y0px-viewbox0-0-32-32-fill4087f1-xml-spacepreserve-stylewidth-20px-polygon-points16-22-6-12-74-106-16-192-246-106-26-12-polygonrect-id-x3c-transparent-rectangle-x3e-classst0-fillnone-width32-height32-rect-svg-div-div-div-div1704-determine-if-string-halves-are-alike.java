class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        int vowelFirst = 0;
        int vowelLast = 0;
       
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if(vowels.contains(s.charAt(i++))) {
                vowelFirst++;
            }
            if(vowels.contains(s.charAt(j--))) {
                vowelLast++;
            }
        }
        return vowelFirst==vowelLast;
    }
}