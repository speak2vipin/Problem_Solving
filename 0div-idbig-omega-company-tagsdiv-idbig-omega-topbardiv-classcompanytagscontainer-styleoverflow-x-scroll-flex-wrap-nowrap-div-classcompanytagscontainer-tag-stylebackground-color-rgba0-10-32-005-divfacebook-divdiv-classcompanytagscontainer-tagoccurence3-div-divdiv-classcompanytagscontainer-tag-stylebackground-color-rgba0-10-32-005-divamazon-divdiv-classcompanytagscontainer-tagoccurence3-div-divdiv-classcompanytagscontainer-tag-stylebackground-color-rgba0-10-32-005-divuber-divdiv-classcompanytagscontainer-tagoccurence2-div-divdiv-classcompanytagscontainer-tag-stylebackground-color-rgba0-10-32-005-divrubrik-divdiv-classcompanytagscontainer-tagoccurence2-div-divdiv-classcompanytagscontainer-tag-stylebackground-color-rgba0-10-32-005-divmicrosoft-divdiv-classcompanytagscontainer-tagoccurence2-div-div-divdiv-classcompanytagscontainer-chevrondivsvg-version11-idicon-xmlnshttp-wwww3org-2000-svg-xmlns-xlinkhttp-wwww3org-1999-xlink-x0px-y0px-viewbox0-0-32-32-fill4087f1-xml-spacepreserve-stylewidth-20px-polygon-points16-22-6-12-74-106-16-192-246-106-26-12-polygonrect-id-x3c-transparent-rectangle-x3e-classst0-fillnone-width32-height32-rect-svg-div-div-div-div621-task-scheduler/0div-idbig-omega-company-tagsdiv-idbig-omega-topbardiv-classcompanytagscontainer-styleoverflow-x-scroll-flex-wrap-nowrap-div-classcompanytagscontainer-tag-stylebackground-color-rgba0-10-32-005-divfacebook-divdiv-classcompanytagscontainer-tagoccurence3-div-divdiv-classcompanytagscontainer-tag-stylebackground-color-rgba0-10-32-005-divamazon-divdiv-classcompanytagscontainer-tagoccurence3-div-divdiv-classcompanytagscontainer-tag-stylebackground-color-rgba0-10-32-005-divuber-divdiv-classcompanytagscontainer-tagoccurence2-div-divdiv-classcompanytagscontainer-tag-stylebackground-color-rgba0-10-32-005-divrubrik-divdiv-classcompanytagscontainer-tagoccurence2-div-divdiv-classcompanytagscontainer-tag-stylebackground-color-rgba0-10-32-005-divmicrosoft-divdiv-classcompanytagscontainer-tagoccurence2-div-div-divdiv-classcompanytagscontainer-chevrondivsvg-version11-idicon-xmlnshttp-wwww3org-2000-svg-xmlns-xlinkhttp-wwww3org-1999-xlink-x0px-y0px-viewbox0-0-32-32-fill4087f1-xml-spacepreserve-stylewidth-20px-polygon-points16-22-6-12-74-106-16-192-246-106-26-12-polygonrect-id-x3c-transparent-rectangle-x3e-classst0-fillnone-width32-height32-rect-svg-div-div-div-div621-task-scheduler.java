class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(char t : tasks) {
            freq[t-'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int f : freq) {
            if(f!=0) {
                pq.offer(f);
            }
        }
        int count = 0;
        while(!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> reprocess = new ArrayList<>();
            int time = 0;
            while(!pq.isEmpty() && cycle>0) {
                int top = pq.poll();
                reprocess.add(top-1);
                time++;
                cycle--;
            }
            for(Integer f : reprocess) {
                if(f>0) {
                    pq.offer(f);
                }
            }
            count += pq.isEmpty()?time:n+1;
        }
        return count;
        
    }
}