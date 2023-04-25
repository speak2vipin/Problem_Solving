class SmallestInfiniteSet {
    
    int [] numbers;
    int smallestPointer = 0;
    PriorityQueue<Integer> pq = null;
    
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
        numbers = new int[1001];
        for(int i=1; i<1001; i++) {
            numbers[i] = 1;
            pq.offer(i);
        }
    }
    
    public int popSmallest() {
        int ans = pq.poll();
        numbers[ans]--;
        return ans;
    }
    
    public void addBack(int num) {
        if(numbers[num]==0) {
            numbers[num]++;
            pq.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */