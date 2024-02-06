class Solution {
   public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String s : strs) {
            String t = new String(s); 
            char l[] = s.toCharArray();
            Arrays.sort(l);
            anagrams
                .computeIfAbsent(new String(l), val->new ArrayList<String>()).add(t);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : anagrams.keySet()) {
            result.add(anagrams.get(key));
        }
        return result;
    }
}