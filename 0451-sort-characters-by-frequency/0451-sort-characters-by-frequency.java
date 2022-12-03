class Solution {
    public String frequencySort(String s) {
		int N = s.length();
		char temp = '\u0000';
		Map<Character, Integer>map = new HashMap<Character, Integer>();
		for(int i=0; i<N; i++) {
			temp = s.charAt(i);
			map.put(temp, map.getOrDefault(temp, 0)+1);
		}
		ValueComparator vc = new ValueComparator(map);
		TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer> (vc);
		treeMap.putAll(map);
		String ans = "";
		for(Character c : treeMap.keySet()) {
			int val = map.get((Character)c);
			while(val-- > 0) {
				ans = ans+c;
			}
		}
		
		return ans;
	}
	
	static class ValueComparator implements Comparator<Character> {
		Map<Character, Integer> map;
		
		@Override
		public int compare(Character s1, Character s2) {
			// TODO Auto-generated method stub
			if(map.get(s1) >= map.get(s2)) {
				return -1;
			} else {
				return 1;
			}
		}

		public ValueComparator(Map<Character, Integer> map) {
			super();
			this.map = map;
		}
		
	}
}