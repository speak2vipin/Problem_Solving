class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int countCharArray[] = new int[26];
        // First String get the freq array of 0th String
        for(int i=0; i<words[0].length(); i++) {
            countCharArray[words[0].charAt(i)-'a']++;
        } 
        
        int currentCharArray[] = new int[26];
        for(int j=1; j<words.length; j++) {
            Arrays.fill(currentCharArray, 0);
            // Get the freq array for jth String
            for(int i=0; i<words[j].length(); i++) {
                currentCharArray[words[j].charAt(i)-'a']++;
            } 
            // Keep only the common characters freq by Math.min
            for(int i=0; i<26; i++) {
                countCharArray[i] = Math.min(countCharArray[i], currentCharArray[i]);
            } 
        }
        
        for(int i=0; i<26; i++) {
            // Retrieve the common characters
            for(int j=0; j<countCharArray[i]; j++) {
                result.add((char)(i+'a')+"");
            }
        }
        
        return result;
    }
}