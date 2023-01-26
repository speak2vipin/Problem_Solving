class Solution {
    int ans = Integer.MAX_VALUE;
    Queue<int[]>qe = new LinkedList<int[]>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, ArrayList<int[]>> adj = new HashMap();
        for(int[] flight : flights) {
            adj.computeIfAbsent(flight[0], val->new ArrayList<int[]>()).add(new int[]{flight[1], flight[2]});
        }
        qe.offer(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
       
		while (!qe.isEmpty() && k-- > -1) {
            int size =  qe.size();
			for (int i = 0; i < size; i++) {
				int[] top = qe.poll();
				List<int[]> list = adj.get(top[0]);
				if (list != null) {
					for (int[] neighbor : list) {
					    int index = neighbor[0];
                        int price = neighbor[1];
                        if(price + top[1]>dist[index]) {
                            continue;
                        }
                        dist[index] = price + top[1];
						qe.offer(new int[] { neighbor[0], price + top[1] });
					}
				}
			}
		}
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
       
    }

}
