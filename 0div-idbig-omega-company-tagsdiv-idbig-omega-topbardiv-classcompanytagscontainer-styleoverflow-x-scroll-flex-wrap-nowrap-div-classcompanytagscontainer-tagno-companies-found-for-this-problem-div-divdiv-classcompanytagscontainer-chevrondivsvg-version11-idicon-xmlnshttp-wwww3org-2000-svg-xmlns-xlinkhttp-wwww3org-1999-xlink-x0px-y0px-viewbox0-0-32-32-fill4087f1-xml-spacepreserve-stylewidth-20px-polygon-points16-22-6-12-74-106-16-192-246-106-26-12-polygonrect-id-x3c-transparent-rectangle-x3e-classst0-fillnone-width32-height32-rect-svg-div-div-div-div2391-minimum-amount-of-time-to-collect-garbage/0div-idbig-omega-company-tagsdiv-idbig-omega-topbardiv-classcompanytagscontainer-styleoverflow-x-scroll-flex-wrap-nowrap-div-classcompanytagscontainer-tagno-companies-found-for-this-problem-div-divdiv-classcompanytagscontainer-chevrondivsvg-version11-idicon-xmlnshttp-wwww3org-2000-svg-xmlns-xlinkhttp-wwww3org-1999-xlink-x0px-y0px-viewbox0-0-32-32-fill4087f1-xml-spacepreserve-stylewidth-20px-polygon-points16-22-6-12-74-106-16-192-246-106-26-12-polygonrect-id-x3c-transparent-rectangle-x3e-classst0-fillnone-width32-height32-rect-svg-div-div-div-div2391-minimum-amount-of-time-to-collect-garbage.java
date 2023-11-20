class Solution {
    // Only trick is if M is present at 2 but not at 3 but again at 4 then sum = till(2) + till(4)
    // But if it is at 2,3 and 4 then till(2) + travel[2] + travel[3]
    // So we can calculate it by prefix array and
    // the farthest occurrence of that character
    // So temp will help me with farthest index of M/D/P
    
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