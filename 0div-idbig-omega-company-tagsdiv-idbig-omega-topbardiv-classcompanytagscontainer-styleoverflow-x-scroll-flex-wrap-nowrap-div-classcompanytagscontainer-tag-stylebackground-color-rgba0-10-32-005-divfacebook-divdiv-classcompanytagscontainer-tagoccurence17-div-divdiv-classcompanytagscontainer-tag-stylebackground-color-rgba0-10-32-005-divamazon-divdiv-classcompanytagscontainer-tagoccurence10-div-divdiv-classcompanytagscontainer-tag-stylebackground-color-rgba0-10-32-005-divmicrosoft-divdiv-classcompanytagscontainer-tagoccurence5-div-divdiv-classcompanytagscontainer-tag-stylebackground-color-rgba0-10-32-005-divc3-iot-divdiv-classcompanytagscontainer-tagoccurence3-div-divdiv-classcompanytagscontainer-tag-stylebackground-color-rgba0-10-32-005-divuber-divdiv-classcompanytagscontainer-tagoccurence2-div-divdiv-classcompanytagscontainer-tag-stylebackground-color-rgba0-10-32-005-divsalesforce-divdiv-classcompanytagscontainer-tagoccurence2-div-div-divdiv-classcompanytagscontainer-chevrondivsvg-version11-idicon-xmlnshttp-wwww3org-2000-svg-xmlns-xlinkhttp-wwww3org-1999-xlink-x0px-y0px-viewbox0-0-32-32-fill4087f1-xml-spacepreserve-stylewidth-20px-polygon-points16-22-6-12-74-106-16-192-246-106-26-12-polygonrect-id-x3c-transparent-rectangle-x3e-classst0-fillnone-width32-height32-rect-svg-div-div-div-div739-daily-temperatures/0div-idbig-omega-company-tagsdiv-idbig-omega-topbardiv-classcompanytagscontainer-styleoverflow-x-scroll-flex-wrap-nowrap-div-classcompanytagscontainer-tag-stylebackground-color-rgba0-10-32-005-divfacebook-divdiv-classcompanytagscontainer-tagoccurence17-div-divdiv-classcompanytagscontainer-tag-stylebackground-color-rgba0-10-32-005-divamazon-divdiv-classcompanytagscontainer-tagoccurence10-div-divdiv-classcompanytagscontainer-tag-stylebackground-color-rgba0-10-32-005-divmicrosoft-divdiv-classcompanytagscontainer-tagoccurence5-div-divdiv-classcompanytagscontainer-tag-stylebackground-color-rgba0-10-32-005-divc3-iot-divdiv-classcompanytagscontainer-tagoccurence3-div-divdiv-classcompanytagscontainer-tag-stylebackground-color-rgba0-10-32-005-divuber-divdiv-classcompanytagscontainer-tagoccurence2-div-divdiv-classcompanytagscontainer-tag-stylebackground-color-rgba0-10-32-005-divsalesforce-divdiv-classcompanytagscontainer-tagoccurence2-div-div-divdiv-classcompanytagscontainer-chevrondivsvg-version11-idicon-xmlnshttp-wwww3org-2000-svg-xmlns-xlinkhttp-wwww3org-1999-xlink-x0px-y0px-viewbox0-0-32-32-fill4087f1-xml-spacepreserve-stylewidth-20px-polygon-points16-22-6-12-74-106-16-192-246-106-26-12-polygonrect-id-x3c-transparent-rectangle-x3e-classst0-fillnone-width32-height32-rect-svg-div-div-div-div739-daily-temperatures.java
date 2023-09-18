class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        //int i = 0;
        int n = temperatures.length;
        int response[] = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {
                int index = st.pop();
                response[index] = i - index;
            }
            st.push(i);
        }
        st.clear();
        return response;
    }
}