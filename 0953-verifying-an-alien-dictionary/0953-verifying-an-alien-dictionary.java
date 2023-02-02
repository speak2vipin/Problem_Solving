class Solution {
    Map<Character, Integer> dic = new HashMap<Character, Integer>();
    
    public boolean isAlienSorted(String[] words, String order) {
        
        int l = order.length();
        for(int i=0; i<l; i++) {
            dic.put(order.charAt(i), i);
        }
        for(int i=1; i<words.length; i++) {
            if(!compare(words[i-1], words[i])) {
                return false;
            }
        }
        return true;
    }
    
    boolean compare(String s1, String s2) {
        int l1 = s1.length()-1;
        int l2 = s2.length()-1;
        int l = l1 > l2 ? l2 : l1;
        char c1 = '\u0000';
        char c2 = '\u0000';
        for(int i=0; i<l+1; i++) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            if(c1!=c2) {
                return dic.get(c1)<dic.get(c2);
            }
        }
       
        return l2>=l1;
    }
}