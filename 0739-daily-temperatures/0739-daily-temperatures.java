class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int answer[] = new int[len];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=len-1; i>-1; i--) {
            if(st.isEmpty()) {
                answer[i] = 0;   
            }
            while(!st.isEmpty()) {
                if(temperatures[st.peek()]>temperatures[i]) {
                    answer[i] = st.peek()-i;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }
        return answer;
        
    }
}