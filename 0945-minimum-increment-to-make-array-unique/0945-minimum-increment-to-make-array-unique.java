class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Queue<Integer> qe = new ArrayDeque<>();
       // int min = num[0];
        for(int num : nums) {
            if(set.contains(num)) {
                qe.offer(num);
            }
            set.add(num);
        }
        
        int ans = 0;
        int temp = -1;
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(temp<top) {
                temp = top;
            }
            while(set.contains(temp)) {
                temp++;
            }
            ans += temp-top;
            set.add(temp);
        }
        return ans;
       
    }
}