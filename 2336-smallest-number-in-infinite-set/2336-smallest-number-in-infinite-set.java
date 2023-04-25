class SmallestInfiniteSet {
    // Logic:
    // A) Take minHeap to fetch the minimum element
    // B) SmallestPointer will take care of initial infinite set
    // C) HashSet would be used just to take care of having repetitive values in minHeap
            // C.1 We can use other method like minHeap.contains() but this would be liner in complexity whereas set.add() would be O(1) operation.
    // If there is any smaller element than smallerPointer than insert it into minHeap or else for natural numbers smallestPointer will help us.
    
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