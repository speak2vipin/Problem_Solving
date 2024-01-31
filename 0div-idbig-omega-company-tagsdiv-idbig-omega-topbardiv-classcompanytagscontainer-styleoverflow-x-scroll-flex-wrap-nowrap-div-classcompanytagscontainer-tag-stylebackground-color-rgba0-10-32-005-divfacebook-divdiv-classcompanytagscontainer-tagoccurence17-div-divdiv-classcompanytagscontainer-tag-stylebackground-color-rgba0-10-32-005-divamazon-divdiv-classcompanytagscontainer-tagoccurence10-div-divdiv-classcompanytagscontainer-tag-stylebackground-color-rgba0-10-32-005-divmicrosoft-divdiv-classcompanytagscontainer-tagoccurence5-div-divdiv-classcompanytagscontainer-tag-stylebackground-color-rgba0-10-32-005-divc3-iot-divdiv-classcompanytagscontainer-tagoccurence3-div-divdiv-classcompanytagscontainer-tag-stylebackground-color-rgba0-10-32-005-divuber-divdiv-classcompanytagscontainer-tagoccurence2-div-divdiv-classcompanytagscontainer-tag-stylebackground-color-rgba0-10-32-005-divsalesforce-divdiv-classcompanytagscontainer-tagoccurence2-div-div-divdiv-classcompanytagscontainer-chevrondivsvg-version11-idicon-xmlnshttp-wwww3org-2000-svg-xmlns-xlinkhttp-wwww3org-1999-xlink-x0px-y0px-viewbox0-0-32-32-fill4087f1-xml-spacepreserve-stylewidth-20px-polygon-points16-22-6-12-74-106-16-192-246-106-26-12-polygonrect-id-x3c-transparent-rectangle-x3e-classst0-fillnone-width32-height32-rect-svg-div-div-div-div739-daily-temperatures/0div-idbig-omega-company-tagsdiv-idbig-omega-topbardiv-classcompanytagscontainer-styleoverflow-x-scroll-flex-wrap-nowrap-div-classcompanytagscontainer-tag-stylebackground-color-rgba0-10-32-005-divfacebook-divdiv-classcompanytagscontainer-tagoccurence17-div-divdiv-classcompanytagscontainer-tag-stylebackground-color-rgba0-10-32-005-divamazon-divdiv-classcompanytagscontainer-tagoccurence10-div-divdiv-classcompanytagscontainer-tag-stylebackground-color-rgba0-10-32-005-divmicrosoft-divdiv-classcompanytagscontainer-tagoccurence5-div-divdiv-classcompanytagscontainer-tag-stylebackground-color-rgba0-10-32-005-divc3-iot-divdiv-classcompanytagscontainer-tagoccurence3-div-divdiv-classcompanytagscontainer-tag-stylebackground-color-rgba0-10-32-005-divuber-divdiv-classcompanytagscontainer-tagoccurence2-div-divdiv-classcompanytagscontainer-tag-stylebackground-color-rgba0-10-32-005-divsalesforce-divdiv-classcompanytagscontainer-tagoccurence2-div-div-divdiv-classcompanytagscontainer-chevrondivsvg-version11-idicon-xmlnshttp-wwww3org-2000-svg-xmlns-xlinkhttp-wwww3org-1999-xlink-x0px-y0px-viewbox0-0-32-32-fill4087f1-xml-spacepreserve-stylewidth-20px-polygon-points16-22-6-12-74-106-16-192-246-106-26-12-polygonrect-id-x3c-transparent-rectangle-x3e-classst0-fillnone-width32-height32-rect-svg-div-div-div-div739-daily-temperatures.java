class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for(int i=n-1; i>-1; i--) {
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                res[i] = st.peek() - i;   
            }
            st.push(i);
        }
        st.clear();
        return res;
    }
}