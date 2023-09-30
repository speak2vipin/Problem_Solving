class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int i = n-1;
        boolean firstStepFlag = false;
        int third = Integer.MIN_VALUE;
        while(i>-1) {
            if(nums[i]<third) {
                return true;
            }
            while(!st.isEmpty() && st.peek()<nums[i]) {
                third = st.pop();
            }
            st.push(nums[i]);
            i--;
        }
        return false;
        
    }
}