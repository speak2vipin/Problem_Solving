class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String words[] = s.split(" ");
        
        int n = words.length;
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            res.append(sb);
            if(i<n-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}