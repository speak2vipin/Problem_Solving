class Solution {
    public String[] shortestSubstrings(String[] arr) {
	    int l = arr.length;
		String result[] = new String[l];
		
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String s : arr) {
			int n = s.length();
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n+1; j++) {
					String sub = s.substring(i, j);
					set.add(sub);
				}
			}
			for (String sub : set) {
				countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
			}
		}

		int index = 0;
		for (String s : arr) {
			String temp = "";
			int n = s.length();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n+1; j++) {
					String sub = s.substring(i, j);
					if (countMap.get(sub) == 1) {
						temp = 
                            (temp.length() == 0) ? sub
								: (sub.length() == temp.length() 
                                   ? (sub.compareTo(temp) < 0 ? sub : temp)
										: (sub.length() > temp.length() ? temp : sub));
					}
				}
			}
			result[index++] = temp;
		}
		return result;
	
	        
    }
}