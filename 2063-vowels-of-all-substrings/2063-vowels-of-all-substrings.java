class Solution {
    public long countVowels(String word) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        
        long count = 0;
        int N = word.length();
        
        for(int i=0; i<N; i++) {
            char temp = word.charAt(i);
            if(vowels.contains(temp)) {
                count += (1l*(N-i)) * (i+1);
               
            }
        }
        return count;   
    }       
}