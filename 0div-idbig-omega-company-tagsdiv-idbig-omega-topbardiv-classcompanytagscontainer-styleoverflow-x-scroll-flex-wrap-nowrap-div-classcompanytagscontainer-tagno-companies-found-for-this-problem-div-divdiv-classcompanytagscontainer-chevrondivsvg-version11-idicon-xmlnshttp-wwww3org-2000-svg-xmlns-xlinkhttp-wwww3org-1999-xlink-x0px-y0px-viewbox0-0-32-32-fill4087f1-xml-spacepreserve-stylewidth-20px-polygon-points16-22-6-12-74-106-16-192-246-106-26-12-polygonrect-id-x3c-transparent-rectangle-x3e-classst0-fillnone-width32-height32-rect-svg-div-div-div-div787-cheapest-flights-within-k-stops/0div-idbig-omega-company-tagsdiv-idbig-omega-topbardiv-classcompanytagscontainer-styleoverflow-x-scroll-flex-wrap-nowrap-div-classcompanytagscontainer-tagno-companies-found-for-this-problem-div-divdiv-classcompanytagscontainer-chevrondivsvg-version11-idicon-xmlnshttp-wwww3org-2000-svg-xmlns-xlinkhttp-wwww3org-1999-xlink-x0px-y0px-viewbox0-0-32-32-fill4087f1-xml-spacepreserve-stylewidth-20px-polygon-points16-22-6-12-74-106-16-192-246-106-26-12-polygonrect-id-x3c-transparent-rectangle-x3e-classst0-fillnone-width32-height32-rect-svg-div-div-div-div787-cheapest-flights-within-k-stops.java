class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
		Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
		Queue<int[]> qe = new LinkedList<int[]>();
		for (int f[] : flights) {
			adj.computeIfAbsent(f[0], val -> new ArrayList<int[]>()).add(new int[] { f[1], f[2] });
		}
		//Queue<int[]> qe = new LinkedList<>();
		qe.offer(new int[] { src, 0, k });
		int vst[] = new int[n];
        Arrays.fill(vst, Integer.MAX_VALUE);
		vst[src] = 0;
		while (!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int top[] = qe.poll();
                ArrayList<int[]> neighbors = 
                    adj.getOrDefault(top[0], new ArrayList<>());
                for (int[] temp : neighbors) {
                    if (top[2] > -1 && vst[temp[0]]>=top[1] + temp[1]) {
                        vst[temp[0]] = top[1] + temp[1];
                        qe.offer(new int[] { temp[0], top[1] + temp[1], top[2] - 1 });
                    }
                }
            }
		}
		return vst[dst]!=Integer.MAX_VALUE?vst[dst]:-1;
	
    }
}