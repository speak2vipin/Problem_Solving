class Solution {
    public boolean halvesAreAlike(String s) {
        int N = s.length();
        int mid = N/2;
        
        List<Character> vowels = new ArrayList<Character>();
        vowels.add('a');vowels.add('A');
        vowels.add('i');vowels.add('I');
        vowels.add('o');vowels.add('O');
        vowels.add('u');vowels.add('U');
        vowels.add('e');vowels.add('E');
        
        int firstHalf = 0;
        int secondHalf = 0;
        int start = 0;
        while(mid<N) {
            if(vowels.contains(s.charAt(start))) {
               firstHalf++; 
            }
            if(vowels.contains(s.charAt(mid))) {
               secondHalf++; 
            }
            start++;
            mid++;  
        }
        
        return firstHalf==secondHalf;
        
    }
}