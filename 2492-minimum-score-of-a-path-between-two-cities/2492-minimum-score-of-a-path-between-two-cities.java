class Solution {
    public int minScore(int n, int[][] roads) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int road[] : roads) {
            adj.computeIfAbsent(road[0], val->new ArrayList<int[]>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1], val->new ArrayList<int[]>()).add(new int[]{road[0], road[2]});
        }
        Queue<Integer> qe = new LinkedList<>();
        qe.offer(1);
        boolean[] vst = new boolean[n+1];
        while(!qe.isEmpty()) {
            Integer top = qe.poll();
            vst[top] = true;
            if(adj.get(top)!=null) {
                for(int[] neighbourAndDist : adj.get(top)) {
                    answer = Math.min(answer, neighbourAndDist[1]);
                    if(!vst[neighbourAndDist[0]]) {
                        qe.offer(neighbourAndDist[0]);
                        vst[neighbourAndDist[0]] = true;
                    }
                }
            }
        }
        return answer;
    }
}