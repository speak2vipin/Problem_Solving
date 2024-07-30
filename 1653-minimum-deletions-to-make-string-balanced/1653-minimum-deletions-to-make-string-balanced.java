class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int deleteCount = 0;
        while(i<s.length()) {
            if(st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                if(s.charAt(i)=='a' && st.peek()=='b') {
                    st.pop();
                    deleteCount++;
                } else {
                    st.push(s.charAt(i));
                }
            }
            i++;
        }
        return deleteCount;
    }
}