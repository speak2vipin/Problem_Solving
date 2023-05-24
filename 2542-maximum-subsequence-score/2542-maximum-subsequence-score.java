class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int N = nums1.length;
        int pair[][] = new int[N][2];
        for(int i=0; i<N; i++) {
            pair[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(pair, (a,b)->b[1]-a[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (a,b)->a-b);
        long sum = 0;
        for(int i=0; i<k; i++) {
            sum += pair[i][0];
            minHeap.offer(pair[i][0]);
        }
        long res = sum * pair[k-1][1];
        for(int i=k; i<N; i++) {
            sum = sum - minHeap.poll() + pair[i][0];
            minHeap.offer(pair[i][0]);
            long tempRes = sum * pair[i][1];
            res = Math.max(res, tempRes);    
        }
        return res;
    }
}