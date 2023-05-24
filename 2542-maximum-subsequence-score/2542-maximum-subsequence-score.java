class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int N = nums1.length;
        
        // Create Pair array having nums1[i] and nums2[i]
        int pair[][] = new int[N][2];
        for(int i=0; i<N; i++) {
            pair[i] = new int[] {nums1[i], nums2[i]};
        }
        
        // Sort it in descending order by pair[1] i.e 1st index element
        Arrays.sort(pair, (a,b)->b[1]-a[1]);
        
        // Min heap to keep track of minimum element
        // As Multiplication:- k elements in nums1 and nums2 i.e sum(nums[i]) * min (nums2[i])
        // We have sorted pair by nums2[i] so min we can get from there
        // To get minimum from nums1 we are using minHeap (So that we can make multiplcation maximum)
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (a,b)->a-b);
        long sum = 0;
        
        for(int i=0; i<k; i++) {
            sum += pair[i][0];
            minHeap.offer(pair[i][0]);
        }
        // Finding res = sum of nums1 * min u will get from pair[k-1][1]
        long res = sum * pair[k-1][1];
        
        // Iterate over array
        for(int i=k; i<N; i++) {
            sum = sum - minHeap.poll() + pair[i][0];
            minHeap.offer(pair[i][0]);
            long tempRes = sum * pair[i][1];
            res = Math.max(res, tempRes);    
        }
        
        return res;
    }
}