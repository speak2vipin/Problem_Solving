class Solution {
    public String getSmallestString(String s) {
        char S[] = s.toCharArray();
        char curr = '\u0000';
        char next = '\u0000';
        for(int i=0; i<s.length()-1; i++) {
            curr = s.charAt(i);
            next = s.charAt(i+1);
            if(curr>next && (curr%2 == next%2)) {
                char temp = S[i];
                S[i] = S[i+1];
                S[i+1] = temp;
                break;
            }
        }
        return new String(S);
    }
}