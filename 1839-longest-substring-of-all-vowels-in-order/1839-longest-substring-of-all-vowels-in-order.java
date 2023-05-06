class Solution {
    public int longestBeautifulSubstring(String word) {
       
        HashMap<Character, Integer> map = new HashMap<>(); 
        map.put('a', 0); map.put('e', 1);
        map.put('i', 2); map.put('o', 3);
        map.put('u', 4); 
        
        
        int N = word.length();
        int i=0; 
        int j=0;
        int count = 0;
            // aeiaaioaaaaeiiiiouuuooaauuaeiu
        while(i<N) {
            char curr = word.charAt(i);
            j = i+1;
            if(curr=='a') {
                HashSet<Character> set = new HashSet<>();
                set.add(curr);
                while(j<N) {
                    char next = word.charAt(j);
                    if(next==curr || (map.get(next)-map.get(curr)==1)) {
                        set.add(next);
                        if(set.size()==5) {
                           count = Math.max(count, j-i+1); 
                        }
                        j++;
                    } else {
                        break;
                    }
                    curr = next;
                }
            }
            i=j;
        }
        return count;
    }
}