class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        
        int maxDistance = 0;
        
        int s = arrays.size();
        
        for(int i=1; i<s; i++) {
            maxDistance = Math.max(maxDistance, Math.abs(max-arrays.get(i).get(0)));
            maxDistance = Math.max(maxDistance, 
                                   Math.abs(min-arrays.get(i).get(arrays.get(i).size()-1)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return maxDistance;
    }
}



