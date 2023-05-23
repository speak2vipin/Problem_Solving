class KthLargest {
    
    PriorityQueue<Integer> heap = null;
    //PriorityQueue<Integer> heap2 = null;
    
    int k = 0;
    int nums[] = null;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        heap = new PriorityQueue<>();
        
        for(int num : nums) {
            heap.offer(num);
        }
        while(heap.size()>k) {
            heap.poll();
        }
    }
    
    public int add(int val) {
       heap.offer(val);
       while(heap.size()>k) {
            heap.poll();
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */