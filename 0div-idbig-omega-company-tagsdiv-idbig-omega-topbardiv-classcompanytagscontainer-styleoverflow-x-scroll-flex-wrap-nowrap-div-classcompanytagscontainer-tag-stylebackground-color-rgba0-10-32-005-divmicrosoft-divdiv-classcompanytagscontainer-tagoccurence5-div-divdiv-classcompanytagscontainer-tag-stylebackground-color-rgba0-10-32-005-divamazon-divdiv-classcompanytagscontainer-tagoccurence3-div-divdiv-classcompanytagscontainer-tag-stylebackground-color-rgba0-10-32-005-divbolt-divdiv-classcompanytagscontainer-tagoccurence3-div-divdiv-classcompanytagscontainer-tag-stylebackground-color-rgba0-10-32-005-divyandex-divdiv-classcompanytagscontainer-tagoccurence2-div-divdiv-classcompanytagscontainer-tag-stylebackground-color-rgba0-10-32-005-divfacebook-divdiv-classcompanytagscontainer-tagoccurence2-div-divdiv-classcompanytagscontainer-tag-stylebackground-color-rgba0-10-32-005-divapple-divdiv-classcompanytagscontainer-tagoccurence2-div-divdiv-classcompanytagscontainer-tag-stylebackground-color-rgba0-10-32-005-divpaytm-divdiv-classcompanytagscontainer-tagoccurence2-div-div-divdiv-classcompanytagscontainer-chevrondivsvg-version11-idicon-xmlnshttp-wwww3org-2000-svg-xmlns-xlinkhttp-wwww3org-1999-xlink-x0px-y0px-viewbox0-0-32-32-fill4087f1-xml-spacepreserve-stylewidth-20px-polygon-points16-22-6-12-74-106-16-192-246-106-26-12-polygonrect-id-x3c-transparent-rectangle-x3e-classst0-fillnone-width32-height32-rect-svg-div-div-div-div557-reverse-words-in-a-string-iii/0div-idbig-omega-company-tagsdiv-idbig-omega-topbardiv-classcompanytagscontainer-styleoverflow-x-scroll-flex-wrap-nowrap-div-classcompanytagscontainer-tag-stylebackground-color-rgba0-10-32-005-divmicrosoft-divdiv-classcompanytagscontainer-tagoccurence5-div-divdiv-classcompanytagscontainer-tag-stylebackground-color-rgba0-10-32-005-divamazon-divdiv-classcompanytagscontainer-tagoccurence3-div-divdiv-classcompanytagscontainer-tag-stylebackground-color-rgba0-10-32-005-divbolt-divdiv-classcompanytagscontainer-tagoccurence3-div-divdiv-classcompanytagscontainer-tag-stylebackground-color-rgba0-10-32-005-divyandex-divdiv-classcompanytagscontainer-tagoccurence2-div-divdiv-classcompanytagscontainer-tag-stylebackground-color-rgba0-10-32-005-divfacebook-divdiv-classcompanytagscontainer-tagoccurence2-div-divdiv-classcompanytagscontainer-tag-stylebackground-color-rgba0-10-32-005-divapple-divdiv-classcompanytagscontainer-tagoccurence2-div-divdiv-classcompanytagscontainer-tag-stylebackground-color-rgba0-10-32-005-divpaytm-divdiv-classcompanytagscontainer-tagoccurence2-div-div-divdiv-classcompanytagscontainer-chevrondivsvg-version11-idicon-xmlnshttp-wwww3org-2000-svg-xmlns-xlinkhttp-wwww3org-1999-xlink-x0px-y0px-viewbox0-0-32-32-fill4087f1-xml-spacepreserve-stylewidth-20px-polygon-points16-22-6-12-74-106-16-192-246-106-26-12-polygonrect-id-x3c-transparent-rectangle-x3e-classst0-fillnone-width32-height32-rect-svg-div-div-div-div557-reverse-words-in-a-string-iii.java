class Solution {
    public String reverseWordsByStringBuilder(String s) {
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
    
    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        
        int n = sArray.length;
        int st = 0;
        int en = 0;
        for(int i=0; i<n; i++) {
            if(sArray[i]==' ') {
                en = i-1;
                reverseString(sArray, st, en);
                st = i+1;
            }
        }
        en = n-1;
        reverseString(sArray, st, en);
        return new String(sArray);
    }
    
    void reverseString(char s[], int st, int en) {
        while(st<en) {
            char temp = s[st];
            s[st] = s[en];
            s[en] = temp;
            st++;
            en--;
        }
        
    }
}