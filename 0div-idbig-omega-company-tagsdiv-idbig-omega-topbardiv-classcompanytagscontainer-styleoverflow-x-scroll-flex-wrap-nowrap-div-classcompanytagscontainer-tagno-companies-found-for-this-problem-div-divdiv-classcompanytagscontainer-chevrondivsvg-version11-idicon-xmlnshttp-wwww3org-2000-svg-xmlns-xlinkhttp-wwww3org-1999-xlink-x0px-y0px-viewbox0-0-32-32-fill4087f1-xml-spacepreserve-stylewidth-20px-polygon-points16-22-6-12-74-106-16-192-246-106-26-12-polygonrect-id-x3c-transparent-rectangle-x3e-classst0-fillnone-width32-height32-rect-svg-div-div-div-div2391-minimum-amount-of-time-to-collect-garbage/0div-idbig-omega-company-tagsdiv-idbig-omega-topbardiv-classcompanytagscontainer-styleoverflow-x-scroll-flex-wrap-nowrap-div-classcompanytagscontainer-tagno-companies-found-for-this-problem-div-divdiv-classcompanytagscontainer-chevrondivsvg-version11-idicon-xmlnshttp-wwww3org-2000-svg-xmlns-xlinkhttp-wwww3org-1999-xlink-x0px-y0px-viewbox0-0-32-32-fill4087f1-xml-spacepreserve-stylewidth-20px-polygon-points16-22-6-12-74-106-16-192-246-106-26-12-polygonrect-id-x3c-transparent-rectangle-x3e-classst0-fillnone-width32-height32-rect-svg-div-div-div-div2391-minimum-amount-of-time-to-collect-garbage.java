class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int n = garbage.length;
        Map<Character, Integer> temp = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<garbage[i].length(); j++) {
                char c = garbage[i].charAt(j);
                temp.put(c, i);
                count++;
            }
        }
        
        for(int i=1; i<n-1; i++) {
            travel[i] = travel[i] + travel[i-1];
        }
        for(Character character : temp.keySet()) {
            if(temp.get(character)-1>=0) {
                count += travel[temp.get(character)-1];
            }
        }
        return count;
        
    }
}