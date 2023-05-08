class Solution {
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