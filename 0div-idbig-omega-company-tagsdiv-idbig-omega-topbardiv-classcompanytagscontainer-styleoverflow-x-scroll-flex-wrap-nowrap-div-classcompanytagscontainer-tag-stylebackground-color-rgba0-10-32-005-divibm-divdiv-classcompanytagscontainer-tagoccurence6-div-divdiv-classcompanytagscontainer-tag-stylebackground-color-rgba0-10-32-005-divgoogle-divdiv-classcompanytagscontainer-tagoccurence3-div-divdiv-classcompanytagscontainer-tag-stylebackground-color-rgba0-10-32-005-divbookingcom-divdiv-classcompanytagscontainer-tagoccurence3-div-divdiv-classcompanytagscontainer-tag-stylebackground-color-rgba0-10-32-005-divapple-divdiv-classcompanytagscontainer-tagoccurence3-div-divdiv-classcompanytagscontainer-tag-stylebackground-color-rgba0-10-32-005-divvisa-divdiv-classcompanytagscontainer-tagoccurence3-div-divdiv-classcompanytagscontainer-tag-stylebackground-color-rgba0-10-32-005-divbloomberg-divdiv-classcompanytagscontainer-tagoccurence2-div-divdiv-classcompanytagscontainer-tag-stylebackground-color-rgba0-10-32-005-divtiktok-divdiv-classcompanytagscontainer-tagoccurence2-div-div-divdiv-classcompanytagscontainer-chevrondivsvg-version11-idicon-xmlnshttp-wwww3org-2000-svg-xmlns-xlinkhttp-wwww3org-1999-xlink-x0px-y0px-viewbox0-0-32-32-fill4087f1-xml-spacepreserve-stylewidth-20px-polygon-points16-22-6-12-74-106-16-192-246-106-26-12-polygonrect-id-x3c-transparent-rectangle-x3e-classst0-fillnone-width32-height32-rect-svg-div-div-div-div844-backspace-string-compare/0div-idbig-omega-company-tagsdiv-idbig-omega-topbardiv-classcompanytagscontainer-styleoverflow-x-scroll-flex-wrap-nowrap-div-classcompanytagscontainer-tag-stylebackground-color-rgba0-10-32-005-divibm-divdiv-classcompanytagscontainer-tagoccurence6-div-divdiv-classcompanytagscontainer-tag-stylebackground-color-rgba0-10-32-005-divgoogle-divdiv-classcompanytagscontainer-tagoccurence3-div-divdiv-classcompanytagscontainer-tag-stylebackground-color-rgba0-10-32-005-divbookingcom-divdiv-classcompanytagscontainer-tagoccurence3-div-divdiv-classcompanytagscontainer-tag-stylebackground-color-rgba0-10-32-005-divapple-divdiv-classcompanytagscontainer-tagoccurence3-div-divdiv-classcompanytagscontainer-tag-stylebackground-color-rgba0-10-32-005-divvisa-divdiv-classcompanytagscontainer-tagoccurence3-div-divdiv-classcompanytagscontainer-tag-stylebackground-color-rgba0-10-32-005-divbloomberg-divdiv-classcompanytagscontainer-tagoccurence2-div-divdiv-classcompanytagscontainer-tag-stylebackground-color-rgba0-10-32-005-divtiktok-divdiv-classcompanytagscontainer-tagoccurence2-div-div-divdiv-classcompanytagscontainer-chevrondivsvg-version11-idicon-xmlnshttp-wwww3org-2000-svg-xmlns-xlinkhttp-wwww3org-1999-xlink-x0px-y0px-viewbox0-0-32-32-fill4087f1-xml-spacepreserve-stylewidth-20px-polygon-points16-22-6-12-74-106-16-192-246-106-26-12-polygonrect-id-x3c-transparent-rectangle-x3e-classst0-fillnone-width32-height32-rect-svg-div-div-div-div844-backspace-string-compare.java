class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int i=0, j=0;
        int sLength = s.length();
        int tLength = t.length();
        while(i<sLength || j<tLength) {
            if(i<sLength) {
                char sChar = s.charAt(i);
                if(sChar=='#') {
                    if(!st1.isEmpty()) {
                        st1.pop();
                    }
                } else {
                    st1.push(sChar);
                }
                i++;
            }
            if(j<tLength) {
                char tChar = t.charAt(j);
                if(tChar=='#') {
                    if(!st2.isEmpty()) {
                        st2.pop();
                    }
                } else {
                    st2.push(tChar);
                }
                j++;    
            }
        }
        if(st1.size()!=st2.size()) {
            return false;
        }
        while(!st1.isEmpty()) {
            if(st1.pop()!=st2.pop()) {
                return false;
            }
        }
        return true;
    }
}