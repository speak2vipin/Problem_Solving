class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
       
        PriorityQueue<int[]> minHeapFront = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> minHeapBack = new PriorityQueue<>((a,b) -> a[1]-b[1] );
        int n = costs.length;
        Set<Integer> set = new HashSet<>();
        int i=0;
        for(i=0; i<candidates; i++) {
            minHeapFront.offer(new int[] {i, costs[i]});
        }
        int j = n-1;
        for(j = n-1; j>n-candidates-1; j--) {
            minHeapBack.offer(new int[] {j, costs[j]});
        }
        long res = 0;
        while(k>0 && !minHeapFront.isEmpty() && !minHeapBack.isEmpty()) {
            if(minHeapFront.peek()[1] > minHeapBack.peek()[1]) {
                int temp[] = minHeapBack.poll(); 
                if(set.contains(temp[0])) {
                    continue;
                }
                set.add(temp[0]);
                res += temp[1];
                if(j>-1) {
                    minHeapBack.offer(new int[] {j, costs[j]});
                    j--;
                }
            } else {
                int temp[] = minHeapFront.poll(); 
                if(set.contains(temp[0])) {
                    continue;
                }
                set.add(temp[0]);
                res += temp[1];
                if(i<n) {
                	minHeapFront.offer(new int[] {i, costs[i]});
                    i++;
                }
            }
            k--;
        }
        if(k>0) {
            PriorityQueue<int[]> fin = minHeapBack.isEmpty() 
                                            ? minHeapFront : minHeapBack;
            while(k>0) {
                int temp[] = fin.poll();
                if(!set.contains(temp[0])) {
                    res += temp[1];
                    set.add(temp[1]);
                    k--;
                }
            }
        }
        return res;
    }
}