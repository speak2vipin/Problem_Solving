class Solution {
    public int reductionOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        int n = nums.length;
        for(int num : nums) {
            pq.offer(num);
        }
        int temp = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            int max = pq.poll();
            temp++;
            while(!pq.isEmpty() && max==pq.peek()) {
                temp++;
                pq.poll();
            }
            if(pq.isEmpty()) {
                return count;
            }
            count += temp;
        }
        return count;
    }
}