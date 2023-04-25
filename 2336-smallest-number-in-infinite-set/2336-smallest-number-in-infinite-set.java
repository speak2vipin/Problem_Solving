class SmallestInfiniteSet {
    
    HashSet<Integer> unique = null;
    int smallestPointer = 0;
    PriorityQueue<Integer> minHeap = null;
    
    public SmallestInfiniteSet() {
        unique = new HashSet<Integer>();
        minHeap = new PriorityQueue<Integer>();
        smallestPointer = 1;
    }
    
    public int popSmallest() {
        int ans = 0;
        if(!minHeap.isEmpty()) {
            ans = minHeap.poll();
            unique.remove(ans);
        } else {
            ans = smallestPointer++;
        }
        return ans;
    }
    
    public void addBack(int num) {
        if(num<smallestPointer && unique.add(num)) {
            minHeap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */