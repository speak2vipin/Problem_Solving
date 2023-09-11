class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> response = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++) {
            map.computeIfAbsent
                (groupSizes[i], val->new ArrayList<Integer>()).add(i);
        }
        Set<Integer>keys = map.keySet();
        for(Integer key : keys) {
            ArrayList<Integer> values = map.get(key);
            List<Integer> l = new ArrayList<Integer>();
            for(int i=1; i<=values.size(); i++) {
                l.add(values.get(i-1));
                if((i%key)==0) {
                    response.add(l);
                    l = new ArrayList<Integer>();
                }
            }
        }
        return response;
    }
}