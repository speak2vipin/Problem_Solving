class Solution {
    public String smallestString(String s) { 
        int N = s.length();
        char res[] = s.toCharArray();
        boolean flag = true;
        for(int i=0; i<N; i++) {
            // Will cover all 'a' in the prefix
            if(s.charAt(i)=='a' && flag) {
                continue;
            } else if(s.charAt(i)=='a' && !flag) { // No need to change further
                break;
            } else {
                // If we got char other than 'a'
                res[i] = (char)(res[i]-1);
                flag = false;
            }
        }
        // If prefix have all a's
        if(flag) {
            res[N-1] = 'z';
        }
        return new String(res);
    }
}