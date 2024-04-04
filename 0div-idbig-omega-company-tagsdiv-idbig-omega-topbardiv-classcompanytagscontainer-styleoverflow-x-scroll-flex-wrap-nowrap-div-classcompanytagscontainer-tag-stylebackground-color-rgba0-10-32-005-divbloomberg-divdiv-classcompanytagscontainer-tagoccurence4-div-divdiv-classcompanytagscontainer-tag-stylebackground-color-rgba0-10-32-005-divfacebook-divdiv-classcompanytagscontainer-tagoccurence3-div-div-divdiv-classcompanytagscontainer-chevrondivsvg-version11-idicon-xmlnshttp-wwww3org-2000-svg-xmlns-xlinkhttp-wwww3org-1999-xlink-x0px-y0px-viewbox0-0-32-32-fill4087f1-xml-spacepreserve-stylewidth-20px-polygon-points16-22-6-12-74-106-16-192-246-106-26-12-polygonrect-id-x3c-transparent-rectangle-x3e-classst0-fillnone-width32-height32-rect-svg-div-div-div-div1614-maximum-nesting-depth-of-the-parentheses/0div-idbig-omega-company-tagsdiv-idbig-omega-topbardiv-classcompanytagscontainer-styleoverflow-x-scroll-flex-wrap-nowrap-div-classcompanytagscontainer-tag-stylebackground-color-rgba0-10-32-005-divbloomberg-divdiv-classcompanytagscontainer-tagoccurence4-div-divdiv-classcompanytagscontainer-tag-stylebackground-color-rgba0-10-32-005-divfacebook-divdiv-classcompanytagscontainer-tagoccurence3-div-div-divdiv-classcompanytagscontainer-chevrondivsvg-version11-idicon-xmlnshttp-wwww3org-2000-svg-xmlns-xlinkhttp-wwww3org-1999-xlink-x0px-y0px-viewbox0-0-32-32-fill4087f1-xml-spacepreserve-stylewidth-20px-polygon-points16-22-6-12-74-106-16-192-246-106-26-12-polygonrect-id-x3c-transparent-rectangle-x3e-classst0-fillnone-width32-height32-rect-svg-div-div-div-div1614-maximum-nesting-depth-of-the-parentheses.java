class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='(') {
                st.push('(');
            } else if(s.charAt(i)==')') {
                st.pop();
            }
            ans = Math.max(ans, st.size());
        }
       
        return ans;
    }
}