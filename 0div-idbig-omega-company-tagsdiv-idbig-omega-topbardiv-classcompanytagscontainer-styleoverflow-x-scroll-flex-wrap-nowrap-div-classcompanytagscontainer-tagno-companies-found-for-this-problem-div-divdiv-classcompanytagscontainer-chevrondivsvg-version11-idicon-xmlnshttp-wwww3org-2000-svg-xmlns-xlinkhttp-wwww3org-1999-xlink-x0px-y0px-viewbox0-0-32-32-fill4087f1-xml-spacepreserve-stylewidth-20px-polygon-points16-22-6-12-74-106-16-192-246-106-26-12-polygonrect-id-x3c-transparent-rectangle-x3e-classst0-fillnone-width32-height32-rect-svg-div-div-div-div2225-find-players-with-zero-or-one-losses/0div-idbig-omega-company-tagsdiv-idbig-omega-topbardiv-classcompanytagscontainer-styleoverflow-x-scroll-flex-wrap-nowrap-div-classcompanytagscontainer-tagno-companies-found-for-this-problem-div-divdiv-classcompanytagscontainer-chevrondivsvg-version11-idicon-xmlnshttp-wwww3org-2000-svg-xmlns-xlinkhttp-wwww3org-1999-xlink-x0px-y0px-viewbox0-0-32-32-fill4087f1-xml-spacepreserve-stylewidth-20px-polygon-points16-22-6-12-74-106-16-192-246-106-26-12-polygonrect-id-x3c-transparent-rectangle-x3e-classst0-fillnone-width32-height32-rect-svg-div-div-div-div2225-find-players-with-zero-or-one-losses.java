class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        
        for(int match[] : matches) {
            in.put(match[1], in.getOrDefault(match[1], 0)+1);
            out.put(match[0], out.getOrDefault(match[0], 0)+1);
        }
        
        TreeSet<Integer> winners = new TreeSet<>();
        TreeSet<Integer> oneLoose = new TreeSet<>();
        for(Integer w : out.keySet()) {
            if(in.containsKey(w) && in.get(w)==1) {
                oneLoose.add(w);
            } else if(!in.containsKey(w)) {
                winners.add(w);
            }
        }
        for(Integer w : in.keySet()) {
            if(in.get(w)==1 && !oneLoose.contains(w)) {
                oneLoose.add(w);
            }
        }
        return 
            Arrays.asList(new ArrayList<>(winners), new ArrayList<>(oneLoose));
        
    }
}