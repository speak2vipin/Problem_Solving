class Solution {
    // Logic
    // Create adj map 
            // having key -> val and weight
            //        val -> key and 1/weight
    // Execute simple DFS
        // Have default distance as -1.0
        // Take visit set to keep track of visited node
        // If there is no mapping for source or destination return -1.0 or de default value
        // if(source == dest) { return val};
        // Execute simple DFS and keep track of val = val * weight
            
    
    Map<String, Map<String, Double>> map = new HashMap<>();
	double res[] = null;
 
    
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int index = 0;
		int size = queries.size();
		res = new double[size];
		for (List<String> eq : equations) {
			map.putIfAbsent(eq.get(0), new HashMap<>());
			map.get(eq.get(0)).put(eq.get(1), values[index]);

			map.putIfAbsent(eq.get(1), new HashMap<>());
			map.get(eq.get(1)).put(eq.get(0), 1.0 / values[index]);
			index++;
		}
		for (int i = 0; i < size; i++) {
			List<String> query = queries.get(i);
			String source = query.get(0);
			String dest = query.get(1);
			HashSet<String> visit = new HashSet<>();
            res[i] = -1.0;
			dfs(visit, source, dest, 1.0, i);
		}
		return res;

	}

	void dfs(HashSet<String> visit, String source, String target, double val, int index) {
		if(map.get(target)==null || map.get(source)==null) {
			res[index] = -1.0;
			return;
		}
		if (target.equals(source)) {
			res[index] = val;
			return;
		}
		if(visit.contains(source)) {
			return;
		}
       
		visit.add(source);
		
		Map<String, Double> temp = map.get(source);
		if (temp != null) {
			for (String key : temp.keySet()) {
				String k = key;
				Double v = temp.get(k);
				dfs(visit, key, target, val * v, index);
			}
		} 
	}
    
}