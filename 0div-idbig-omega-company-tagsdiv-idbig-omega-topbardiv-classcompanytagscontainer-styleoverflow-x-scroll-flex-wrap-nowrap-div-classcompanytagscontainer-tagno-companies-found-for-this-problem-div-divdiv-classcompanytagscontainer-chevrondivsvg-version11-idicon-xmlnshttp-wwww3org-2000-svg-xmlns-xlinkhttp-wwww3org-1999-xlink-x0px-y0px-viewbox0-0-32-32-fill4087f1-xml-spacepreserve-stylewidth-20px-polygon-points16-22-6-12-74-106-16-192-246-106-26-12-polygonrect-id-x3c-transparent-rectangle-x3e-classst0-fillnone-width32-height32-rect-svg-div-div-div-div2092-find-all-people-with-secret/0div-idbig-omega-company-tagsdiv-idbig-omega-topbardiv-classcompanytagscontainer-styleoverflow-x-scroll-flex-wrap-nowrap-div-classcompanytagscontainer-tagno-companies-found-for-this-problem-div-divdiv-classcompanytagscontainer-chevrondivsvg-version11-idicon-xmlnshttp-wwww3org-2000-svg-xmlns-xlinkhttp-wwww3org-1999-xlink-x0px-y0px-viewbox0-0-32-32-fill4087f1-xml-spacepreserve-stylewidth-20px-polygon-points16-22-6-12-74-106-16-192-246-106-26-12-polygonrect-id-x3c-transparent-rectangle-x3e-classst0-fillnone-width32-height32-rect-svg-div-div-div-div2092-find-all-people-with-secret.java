class Solution {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
		
		Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
		for (int meet[] : meetings) {
			adj.computeIfAbsent(meet[0], val -> new ArrayList<int[]>()).add(new int[] { meet[1], meet[2] });
			adj.computeIfAbsent(meet[1], val -> new ArrayList<int[]>()).add(new int[] { meet[0], meet[2] });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> (x[1] - y[1]));
		Set<Integer> res = new HashSet<>();
		
		pq.offer(new int[] {firstPerson, 0});
        pq.offer(new int[]{0, 0});
        
		while (!pq.isEmpty()) {
			int top[] = pq.poll();
            int time = top[1];
            int person = top[0];
            if(res.contains(person)) {
                continue;
            }
            res.add(person);
            
			if (adj.get(person) != null) {
				for (int[] x : adj.get(person)) {
					if (x[1] >= time && !res.contains(x[0])) {
						pq.offer(new int[] { x[0], x[1] });
					}
				}
			}
		}
                                             
         //for(int i = 0; i<n; i++) {
           //  if(vst[i]) {
             //    res.add(i);
             //}
         //}                                    
		return new ArrayList<>(res);

	}
                    
}