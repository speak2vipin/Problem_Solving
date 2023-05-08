class Solution {
    // Logic
        // will be using Sliding window
        // keep on counting ferquency of every character
        // If each character's index is greater than 0 than reduce left hand window till we are reducing count of one charcter to 0
            // In parallel keep on counting number of abc count
        // keep on adding to count variable the occurrence of abc substring.
    public int numberOfSubstrings(String s) {
       // HashSet<Character> set = new HashSet<>();
        char character[] = new char[3];
        int N = s.length();
        long count = 0;
        //int i = 0;
        int j = 0;
        for(int i=0; i<N; i++) {
            character[s.charAt(i)-'a']++;
            while(character[0]>0 && character[1]>0 && character[2]>0) {
                character[s.charAt(j++)-'a']--;
            }
            count = count+j;
        }
        return (int)count;
        
    }
}