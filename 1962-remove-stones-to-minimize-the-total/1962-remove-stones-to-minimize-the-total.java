class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        int total = 0;
        int N = piles.length-1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<=N; i++) {
            pq.add((-1)*piles[i]);
        }
        while(k>0) {
            int temp = pq.remove();
            pq.add(temp-(temp/2));
            k--;
        }
       
        for(Integer stones : pq) {
            total += (-1)*stones;
        }
        return total; 
    
    }
}