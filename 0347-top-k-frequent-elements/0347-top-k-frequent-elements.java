class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                @Override
                public int compare(int x[], int y[]) {
                    return y[1] - x[1];
                }
            });
        for(Integer key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }
        int res[] = new int[k];
        int i = 0;
        while(k>0) {
            res[i] = pq.poll()[0];
            k--;
            i++;
        }
        return res;
    
    }
}