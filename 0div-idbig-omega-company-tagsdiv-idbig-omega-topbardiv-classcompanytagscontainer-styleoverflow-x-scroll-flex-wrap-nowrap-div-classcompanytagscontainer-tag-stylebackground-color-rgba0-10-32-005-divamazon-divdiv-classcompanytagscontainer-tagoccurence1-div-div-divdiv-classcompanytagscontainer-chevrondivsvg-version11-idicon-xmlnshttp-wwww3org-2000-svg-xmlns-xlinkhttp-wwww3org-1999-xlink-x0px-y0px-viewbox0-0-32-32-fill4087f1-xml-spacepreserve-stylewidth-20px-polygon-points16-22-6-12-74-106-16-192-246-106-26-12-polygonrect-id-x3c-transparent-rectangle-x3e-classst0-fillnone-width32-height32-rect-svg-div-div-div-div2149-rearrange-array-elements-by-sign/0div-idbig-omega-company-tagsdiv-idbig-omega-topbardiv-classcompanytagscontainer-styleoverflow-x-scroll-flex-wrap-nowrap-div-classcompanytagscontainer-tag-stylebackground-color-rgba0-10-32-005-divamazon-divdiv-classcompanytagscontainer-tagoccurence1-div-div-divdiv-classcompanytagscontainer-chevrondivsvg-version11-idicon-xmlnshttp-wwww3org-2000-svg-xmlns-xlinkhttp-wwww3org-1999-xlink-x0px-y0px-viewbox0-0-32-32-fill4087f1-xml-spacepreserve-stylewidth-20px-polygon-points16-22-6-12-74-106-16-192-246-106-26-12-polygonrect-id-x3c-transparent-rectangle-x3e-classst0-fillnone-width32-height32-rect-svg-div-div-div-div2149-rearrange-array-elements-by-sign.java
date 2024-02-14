class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();
        for(int num : nums) {
            if(num>0) {
                positive.offer(num);
            } else {
                negative.offer(num);
            }
        }
        int index = 0;
        int res[] = new int[nums.length];
        while(!positive.isEmpty() || !negative.isEmpty()) {
            res[index] = (index%2==0) ? positive.poll() : negative.poll();
            index++;
        }
        return res;
    }
}