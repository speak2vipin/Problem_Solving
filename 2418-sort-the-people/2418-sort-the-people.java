class Solution {
    public String[] sortPeopleUsingSorting(String[] names, int[] heights) {
        int len = names.length;
        Integer[]index = new Integer[len];
        for(int i=0; i<len; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i1,i2)->Integer.compare(heights[i2], heights[i1]));
        String res[] = new String[len];
        for(int i=0; i<len; i++) {
            res[i] = names[index[i]];
        }
        return res;
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        
        Map<Integer, String> heightsMap = new HashMap<>();
        
        for(int i=0; i<len; i++) {
            heightsMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        
        String res[] = new String[len];
        for(int i=len-1; i>-1; i--) {
            res[len-1-i] = heightsMap.get(heights[i]);
        }
        return res;
    
    }
}