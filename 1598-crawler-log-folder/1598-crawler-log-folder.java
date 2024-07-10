class Solution {
    public int minOperations(String[] logs) {
        String entry = "dummy";
        Stack<String> st = new Stack<>();
        for(String s : logs) {
            if(s.equals("../")) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else if(!s.equals("./")) {
                st.push(entry);
            }
        }
        return st.size();
    }
}