class Solution {
    public int countCharacters(String[] words, String chars) {
        int count[] = new int[26];
        for(int i=0; i<chars.length(); i++) {
            int index = chars.charAt(i)-'a';
            count[index]++;
        }
        int sum = 0;
        int tempCount[];
        for(String s : words) {
            boolean isComplete = true;
            tempCount = count.clone();
            for(int i=0; i<s.length(); i++) {
                int index = s.charAt(i)-'a';
                if(tempCount[index]-- == 0) {
                    isComplete = false;
                    break;
                }
            }
            if(isComplete) {
                sum += s.length();
            }
        }
        return sum;
    }
}