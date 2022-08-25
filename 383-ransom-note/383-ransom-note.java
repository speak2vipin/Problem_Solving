class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int charA[] = new int[26];
        for(int i=0;i<magazine.length();i++) {
            charA[magazine.charAt(i)-'a']++;
        }
        char c;
        for(int i=0;i<ransomNote.length();i++) {
            c = ransomNote.charAt(i);
            if(charA[c-'a']==0) {
                return false;
            } else {
                charA[c-'a']--;
            }
        }
        return true;     
    }
}