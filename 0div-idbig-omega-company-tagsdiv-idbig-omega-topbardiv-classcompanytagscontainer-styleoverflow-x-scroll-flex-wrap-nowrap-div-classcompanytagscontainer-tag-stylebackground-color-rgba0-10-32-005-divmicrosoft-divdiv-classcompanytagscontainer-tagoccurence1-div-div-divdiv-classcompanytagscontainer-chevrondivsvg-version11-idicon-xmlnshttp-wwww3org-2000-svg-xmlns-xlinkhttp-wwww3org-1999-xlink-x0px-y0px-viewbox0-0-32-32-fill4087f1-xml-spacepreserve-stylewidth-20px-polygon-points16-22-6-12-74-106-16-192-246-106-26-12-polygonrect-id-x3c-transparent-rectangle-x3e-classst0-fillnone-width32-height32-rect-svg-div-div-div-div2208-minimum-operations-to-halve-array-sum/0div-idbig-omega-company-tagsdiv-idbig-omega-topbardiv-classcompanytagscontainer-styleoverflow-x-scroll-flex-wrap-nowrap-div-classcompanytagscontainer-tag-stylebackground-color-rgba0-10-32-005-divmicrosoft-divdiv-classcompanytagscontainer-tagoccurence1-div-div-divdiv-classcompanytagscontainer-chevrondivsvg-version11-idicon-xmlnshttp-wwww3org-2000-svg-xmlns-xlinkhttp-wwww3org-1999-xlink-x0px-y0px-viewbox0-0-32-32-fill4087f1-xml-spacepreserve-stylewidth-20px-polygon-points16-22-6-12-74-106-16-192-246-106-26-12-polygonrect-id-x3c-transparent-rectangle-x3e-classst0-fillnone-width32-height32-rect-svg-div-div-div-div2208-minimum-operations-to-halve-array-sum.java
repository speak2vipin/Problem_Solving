class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
        double sum = 0;
        for(int num : nums) {
            double d = (double)num;
            sum += d;
            pq.offer(d);
        }
        int result = 0;
        double tempSum = sum;
        while(tempSum>(sum/2)) {
            double max = pq.poll()/2;
            pq.offer(max);
            tempSum -= max;
            result++;
        }
        return result;
        
    }
}