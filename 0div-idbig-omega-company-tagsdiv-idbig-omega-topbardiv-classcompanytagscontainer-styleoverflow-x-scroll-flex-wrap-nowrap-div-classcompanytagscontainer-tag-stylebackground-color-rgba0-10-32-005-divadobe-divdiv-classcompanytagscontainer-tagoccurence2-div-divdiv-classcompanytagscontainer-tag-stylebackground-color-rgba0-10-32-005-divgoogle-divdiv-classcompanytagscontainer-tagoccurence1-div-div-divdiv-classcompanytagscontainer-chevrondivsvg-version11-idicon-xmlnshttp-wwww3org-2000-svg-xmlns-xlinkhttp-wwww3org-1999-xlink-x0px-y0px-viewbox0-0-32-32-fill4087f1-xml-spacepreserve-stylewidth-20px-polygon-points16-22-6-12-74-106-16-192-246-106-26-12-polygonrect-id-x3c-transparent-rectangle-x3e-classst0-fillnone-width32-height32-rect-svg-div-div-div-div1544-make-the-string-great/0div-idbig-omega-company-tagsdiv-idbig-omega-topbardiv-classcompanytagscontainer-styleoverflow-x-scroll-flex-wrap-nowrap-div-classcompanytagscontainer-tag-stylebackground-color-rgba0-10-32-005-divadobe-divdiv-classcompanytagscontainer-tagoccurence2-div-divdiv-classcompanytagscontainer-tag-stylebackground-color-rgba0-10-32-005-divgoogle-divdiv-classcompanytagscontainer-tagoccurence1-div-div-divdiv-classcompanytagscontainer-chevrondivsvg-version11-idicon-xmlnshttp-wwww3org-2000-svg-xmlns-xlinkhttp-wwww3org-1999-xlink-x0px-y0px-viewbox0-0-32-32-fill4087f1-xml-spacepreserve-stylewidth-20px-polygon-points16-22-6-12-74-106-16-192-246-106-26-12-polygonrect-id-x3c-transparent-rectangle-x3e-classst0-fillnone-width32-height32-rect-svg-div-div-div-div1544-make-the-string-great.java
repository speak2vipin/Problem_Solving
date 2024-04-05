class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(!st.isEmpty() && (st.peek()==c+32 || st.peek()==c-32)) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop()+ans;
        }
        return ans;
    }
}