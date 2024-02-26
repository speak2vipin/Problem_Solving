class Solution {
    Trie root = null;

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		for (String s : products) {
			formTrie(s);
		}
        boolean attempt = true;
		List<List<String>> result = new ArrayList<>();
		for (int i = 0; i < searchWord.length(); i++) {
			int index = searchWord.charAt(i) - 'a';
            List<String> tempResult = new ArrayList<>();
			if (root != null && root.trie[index]!=null && attempt) {
                int count = 0;
                for(String s1 : new ArrayList<String>(root.trie[index].set)) {
                    tempResult.add(s1);
                    if(++count>=3) {
                        break;
                    } 
                }
				root = root.trie[index];
			} else {
				attempt = false;
			}
            result.add(tempResult);
		}
		return result;
	}

	void formTrie(String s) {
		if (root == null) {
			root = new Trie();
		}
		Trie temp = root;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (temp.trie[index] == null) {
				temp.trie[index] = new Trie();
			}
			temp = temp.trie[index];
            temp.set.add(s);
		}
	}
}

	class Trie {
		Trie[] trie;
		TreeSet<String> set;

		public Trie() {
			trie = new Trie[26];
			set = new TreeSet<>();
		}
	}