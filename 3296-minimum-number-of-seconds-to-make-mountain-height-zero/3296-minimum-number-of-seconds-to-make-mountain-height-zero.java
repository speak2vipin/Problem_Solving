class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x,y)->Long.compare(x[0], y[0]));
        for(int work : workerTimes) {
            pq.offer(new long[]{work, work, 1l});
        }

        while(mountainHeight>1) {
            long topWork[] = pq.poll();
            long times = topWork[2]+1;
            pq.offer(new long[]{
                topWork[0]+(times*topWork[1]), 
                topWork[1], 
                times});
            mountainHeight--;
        }
        return pq.poll()[0];
    }
}


    