class Solution {
    // Bruteforce type
    // Find the existence of String in Bank by replacing all the caracter with 'A', 'C','G','T'
    public int minMutation(String start, String end, String[] bank) {
        
		char genes[] = { 'A', 'C', 'G', 'T' };
		if (start.equals(end)) {
			return 0;
		} else if (bank.length == 0) {
			return -1;
		}
		
		int level = 0;
		List<String> bankString = new ArrayList<String>();
		for(String b : bank) {
			bankString.add(b);
		}
		Queue<String> sList = new LinkedList<String>();
		Set<String>visited = new HashSet<String> ();
		sList.offer(start);
		while (!sList.isEmpty()) {
			int size = sList.size();
			while (size-- > 0) {
				
				String s = sList.poll();		//AAAAACCC || AAAACCCC","AAACCCCC","AACCCCCC" || AACCCCCC
				if(s.equals(end)) {
					return level;
				}
				for (int i = 0; i < s.length(); i++) {
					char[] charArray = s.toCharArray();
					for (int j = 0; j < genes.length; j++) {
						charArray[i] = genes[j];
						String temp = new String(charArray);
						if (visited.add(temp) && bankString.contains(temp)) {
							sList.offer(temp);
							//visited.add(temp);
						}

					}
				}
			}
			if(!sList.isEmpty())
				level++;
		}
		return -1;
	
     
    }
}