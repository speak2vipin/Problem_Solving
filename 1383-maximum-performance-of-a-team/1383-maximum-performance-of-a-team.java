class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
      /*  int N = speed.length;
        int [][]temp = new int[N][2];
        for(int i=0; i<N; i++) {
            temp[i] = new int[] {efficiency[i], speed[i]};
        }
        // Sort in Desecnding order by efficiency
        Arrays.sort(temp, (a,b) -> b[0] - a[0]);
        // Default order i.e. Ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int sum = 0;
        int netEfficiency = 0;
        for(int i=0; i<N; i++) {
            netEfficiency+=temp[i][1];
            pq.add(temp[i][1]);
            if(pq.size()>k) {
                netEfficiency-=pq.poll();
            }
            // Trick is here i.e if in Queue, didn't get higher number than              //netEfficiency will not change and we knows A[0] would be in descending order so it's //multiply will not be higher than it's previos value for sure.
            sum = Math.max(sum, netEfficiency*temp[i][0]);
        }
        return (int) (sum % (long) (1e9 + 7));*/
        int[][] ess = new int[n][2];
		for (int i = 0; i < n; ++i)
			ess[i] = new int[] { efficiency[i], speed[i] };
		Arrays.sort(ess, (a, b) -> b[0] - a[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
		long res = 0, sumS = 0;
		for (int[] es : ess) {
			pq.add(es[1]);
			sumS = (sumS + es[1]);
			if (pq.size() > k)
				sumS -= pq.poll();
			res = Math.max(res, (sumS * es[0]));
		}
		return (int) (res % (long) (1e9 + 7));
    }
}