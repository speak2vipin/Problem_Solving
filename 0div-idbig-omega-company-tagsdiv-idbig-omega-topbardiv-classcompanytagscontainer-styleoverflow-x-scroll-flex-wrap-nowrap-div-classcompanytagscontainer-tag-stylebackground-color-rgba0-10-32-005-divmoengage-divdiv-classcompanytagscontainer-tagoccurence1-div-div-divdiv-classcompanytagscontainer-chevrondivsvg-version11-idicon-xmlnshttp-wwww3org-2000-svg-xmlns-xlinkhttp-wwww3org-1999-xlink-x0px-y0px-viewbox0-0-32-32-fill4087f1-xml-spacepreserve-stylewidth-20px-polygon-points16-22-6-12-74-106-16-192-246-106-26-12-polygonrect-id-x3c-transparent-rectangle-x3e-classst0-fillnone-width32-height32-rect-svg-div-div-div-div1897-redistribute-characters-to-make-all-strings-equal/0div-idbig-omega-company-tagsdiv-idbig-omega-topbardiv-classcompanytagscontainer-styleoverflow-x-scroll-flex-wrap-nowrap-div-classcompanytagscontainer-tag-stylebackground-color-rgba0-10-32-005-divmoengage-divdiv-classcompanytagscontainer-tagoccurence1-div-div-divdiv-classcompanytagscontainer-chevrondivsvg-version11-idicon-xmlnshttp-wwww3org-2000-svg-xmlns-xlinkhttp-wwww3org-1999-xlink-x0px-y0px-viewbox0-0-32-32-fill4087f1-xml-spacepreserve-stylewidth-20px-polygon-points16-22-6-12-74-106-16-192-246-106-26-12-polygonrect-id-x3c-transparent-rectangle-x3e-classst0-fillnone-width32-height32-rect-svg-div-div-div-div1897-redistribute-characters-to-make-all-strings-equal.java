class Solution {
    public boolean makeEqual(String[] words) {
        int count[] = new int[26];
        for(String word : words) {
            int n = word.length();
            for(int i=0; i<n; i++) {
                int index = word.charAt(i)-'a';
                count[index]++;
            }
        }
        int N = words.length;
        for(int c : count) {
            if((c%N)!=0) {
                return false;
            }
        }
        return true;
    }
}