class Solution {
    public String smallestString(String s) { 
        int N = s.length();
        char res[] = s.toCharArray();
        boolean flag = true;
        for(int i=0; i<N; i++) {
            if(s.charAt(i)=='a' && flag) {
                continue;
            } else if(s.charAt(i)=='a' && !flag) {
                break;
            } else {
                res[i] = (char)(res[i]-1);
                flag = false;
            }
        }
        if(flag) {
            res[N-1] = 'z';
        }
        return new String(res);
    }
}