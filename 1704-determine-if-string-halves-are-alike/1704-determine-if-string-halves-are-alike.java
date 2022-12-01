class Solution {
    public boolean halvesAreAlike(String s) {
        int N = s.length();
        int mid = N/2;
        
         List<Character> vowels = 
             List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        int count = 0;
        int secondHalf = 0;
        int start = 0;
        while(mid<N) {
            if(vowels.contains(s.charAt(start))) {
               count++; 
            }
            if(vowels.contains(s.charAt(mid))) {
               count--; 
            }
            start++;
            mid++;  
        }
        
        return count==0;
        
    }
}