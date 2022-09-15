class Solution {
    public int[] findOriginalArray(int[] changed) { 
		int N = changed.length;
        if(N==0 || N%2!=0) {
            return new int[] {};
        }
		Integer[] temp = new Integer[N];
		Arrays.setAll(temp, i -> changed[i]);
		Arrays.sort(temp, Collections.reverseOrder());
		List<Integer> list = Arrays.asList(temp);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer t : list) {
			map.put(t, map.getOrDefault(t, 0)+1);
		}
		int count = 0;
		Iterator<Integer> iterator = list.iterator();
		List<Integer> output = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			int num = (Integer) iterator.next();
			if (num%2==0 && map.get(num)!=null && map.get(num)>0 && num==num/2 && map.get(num/2)!=null && map.get(num/2)>1) {
				output.add(num/2);
				map.put(num, map.get(num)-2);	
			} 
            else if(num%2==0 && map.get(num)!=null && map.get(num)>0 && num!=num/2 && map.get(num/2)!=null && map.get(num/2)>0 ) {
				output.add(num/2);
				map.put(num/2, map.get(num/2)-1);
                map.put(num, map.get(num)-1);
			}
		}
	
		int size = output.size();
		if(size!=N/2) {
			return new int[] {};
		}
		int ans[] = new int[size];
	    for(int i=0; i<size;i++) {
	    	ans[i] = output.get(i);
	    }
		return ans;
    }
}