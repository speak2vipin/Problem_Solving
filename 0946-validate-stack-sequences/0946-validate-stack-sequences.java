class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
 
        int N = pushed.length;
        
        int j=0;
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N; i++) {
            st.push(pushed[i]);
            while(j<N && !st.isEmpty() && st.peek()== popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == N;
        
    }
}