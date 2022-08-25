class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int charA[] = new int[26];
        for(int i=0;i<magazine.length();i++) {
            charA[magazine.charAt(i)-'a']++;
        }
        
        for(int i=0;i<ransomNote.length();i++) {
            if(charA[ransomNote.charAt(i)-'a']==0) {
                return false;
            } else {
                charA[ransomNote.charAt(i)-'a']--;
            }
        }
        return true;     
    }
}