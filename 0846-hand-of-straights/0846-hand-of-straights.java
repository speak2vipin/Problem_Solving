class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int h :  hand) {
            pq.offer(h);
            freq.put(h, freq.getOrDefault(h, 0)+1);
        }
        while(freq.size()>0) {
            int min = pq.peek();
            for(int i=0; i<groupSize; i++) {
                if(freq.get(min)!=null) {
                    if(freq.get(min)==1) {
                        freq.remove(min);
                    } else {
                        freq.put(min, freq.get(min)-1);
                    }
                    pq.remove(min);
                } else {
                    return false;
                }
                min++;
            }
        }
        return true;
    }
}