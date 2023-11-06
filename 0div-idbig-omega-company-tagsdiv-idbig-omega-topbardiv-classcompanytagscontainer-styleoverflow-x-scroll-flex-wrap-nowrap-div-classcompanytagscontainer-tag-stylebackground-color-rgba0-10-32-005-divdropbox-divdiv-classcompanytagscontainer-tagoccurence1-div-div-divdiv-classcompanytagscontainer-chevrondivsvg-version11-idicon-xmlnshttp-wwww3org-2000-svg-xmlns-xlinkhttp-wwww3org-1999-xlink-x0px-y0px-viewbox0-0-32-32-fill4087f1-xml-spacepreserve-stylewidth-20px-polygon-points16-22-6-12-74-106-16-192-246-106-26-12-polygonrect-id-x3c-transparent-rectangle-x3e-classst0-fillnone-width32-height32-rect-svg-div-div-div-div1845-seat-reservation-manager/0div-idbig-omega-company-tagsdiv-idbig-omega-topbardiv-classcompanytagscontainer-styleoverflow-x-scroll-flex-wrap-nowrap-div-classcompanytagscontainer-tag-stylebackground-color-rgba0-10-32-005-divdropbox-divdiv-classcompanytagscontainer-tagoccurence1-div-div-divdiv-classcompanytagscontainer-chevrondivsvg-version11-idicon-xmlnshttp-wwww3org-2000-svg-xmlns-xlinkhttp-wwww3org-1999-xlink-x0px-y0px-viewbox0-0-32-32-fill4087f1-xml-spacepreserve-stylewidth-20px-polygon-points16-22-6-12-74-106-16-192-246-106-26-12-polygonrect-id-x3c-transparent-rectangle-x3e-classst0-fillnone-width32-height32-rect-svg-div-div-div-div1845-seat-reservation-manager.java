class SeatManager {
    PriorityQueue<Integer> minHeap = null;
    int marker;
        
    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        marker = 0;
    }
    
    public int reserve() {
        int minSeat = 0; 
        if(!minHeap.isEmpty()) {
            minSeat = minHeap.poll();
        } else {
            minSeat = ++marker;
        }
        return minSeat;
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */