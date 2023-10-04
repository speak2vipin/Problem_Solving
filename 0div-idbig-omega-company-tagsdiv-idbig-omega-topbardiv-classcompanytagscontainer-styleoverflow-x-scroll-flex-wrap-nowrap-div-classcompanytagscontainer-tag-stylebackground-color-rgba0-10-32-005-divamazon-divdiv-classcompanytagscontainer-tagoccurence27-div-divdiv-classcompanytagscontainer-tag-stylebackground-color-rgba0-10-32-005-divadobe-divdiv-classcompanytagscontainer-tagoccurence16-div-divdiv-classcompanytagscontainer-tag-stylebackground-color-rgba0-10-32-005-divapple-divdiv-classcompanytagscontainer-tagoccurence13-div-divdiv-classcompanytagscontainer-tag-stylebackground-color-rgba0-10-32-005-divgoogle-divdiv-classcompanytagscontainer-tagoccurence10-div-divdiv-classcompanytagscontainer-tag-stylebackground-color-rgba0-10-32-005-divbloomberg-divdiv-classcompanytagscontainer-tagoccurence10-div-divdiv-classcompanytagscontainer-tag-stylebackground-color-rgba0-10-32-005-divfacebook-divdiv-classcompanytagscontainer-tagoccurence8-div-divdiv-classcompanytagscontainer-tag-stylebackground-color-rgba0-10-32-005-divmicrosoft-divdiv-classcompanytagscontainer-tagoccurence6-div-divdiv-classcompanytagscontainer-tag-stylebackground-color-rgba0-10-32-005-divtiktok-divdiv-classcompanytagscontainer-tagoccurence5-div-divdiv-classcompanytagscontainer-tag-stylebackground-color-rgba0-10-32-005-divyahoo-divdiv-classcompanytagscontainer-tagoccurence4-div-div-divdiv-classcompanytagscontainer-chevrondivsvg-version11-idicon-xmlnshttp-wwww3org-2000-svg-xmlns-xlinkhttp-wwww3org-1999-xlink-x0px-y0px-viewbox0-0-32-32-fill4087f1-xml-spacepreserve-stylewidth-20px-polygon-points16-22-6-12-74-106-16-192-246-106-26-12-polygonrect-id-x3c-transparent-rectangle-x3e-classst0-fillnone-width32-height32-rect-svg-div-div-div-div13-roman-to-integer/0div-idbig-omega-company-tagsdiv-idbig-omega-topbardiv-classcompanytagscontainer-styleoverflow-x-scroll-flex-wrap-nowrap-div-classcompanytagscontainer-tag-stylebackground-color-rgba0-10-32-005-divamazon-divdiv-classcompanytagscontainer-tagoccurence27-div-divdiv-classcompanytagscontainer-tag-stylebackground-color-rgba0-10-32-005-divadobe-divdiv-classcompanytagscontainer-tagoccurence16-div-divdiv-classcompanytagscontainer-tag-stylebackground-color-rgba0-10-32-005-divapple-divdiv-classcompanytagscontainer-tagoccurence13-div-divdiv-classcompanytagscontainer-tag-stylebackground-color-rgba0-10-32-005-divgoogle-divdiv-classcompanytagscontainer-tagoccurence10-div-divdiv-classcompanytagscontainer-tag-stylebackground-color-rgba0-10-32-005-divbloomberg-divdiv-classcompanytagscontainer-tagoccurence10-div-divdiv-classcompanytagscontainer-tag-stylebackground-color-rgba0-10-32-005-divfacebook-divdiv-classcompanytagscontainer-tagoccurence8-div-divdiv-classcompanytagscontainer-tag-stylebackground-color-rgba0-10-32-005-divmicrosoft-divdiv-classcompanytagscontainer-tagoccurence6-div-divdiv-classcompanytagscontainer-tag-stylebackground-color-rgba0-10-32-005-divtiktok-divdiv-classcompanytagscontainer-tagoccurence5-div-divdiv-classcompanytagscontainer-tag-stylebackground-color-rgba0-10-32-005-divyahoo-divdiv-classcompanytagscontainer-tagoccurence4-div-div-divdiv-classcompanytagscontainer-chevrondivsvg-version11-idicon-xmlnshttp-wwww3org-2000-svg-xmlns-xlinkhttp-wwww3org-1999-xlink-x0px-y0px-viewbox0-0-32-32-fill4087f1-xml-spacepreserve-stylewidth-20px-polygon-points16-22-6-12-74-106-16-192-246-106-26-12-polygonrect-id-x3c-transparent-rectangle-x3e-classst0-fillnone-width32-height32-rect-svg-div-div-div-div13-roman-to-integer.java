class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number = 0;
        for(int i=0; i<n; i++) {
            char curr = s.charAt(i);
            if(i+1<n) {
               char next = s.charAt(i+1);
               if(map.get(curr)<map.get(next)) {
                   number += (-1) * map.get(curr);
                   continue;
               } 
            }
            number += map.get(curr);
        }
        return number;
    }
}