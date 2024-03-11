class Solution {
    public String customSortString(String order, String s) {
        int index[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            index[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            int tempIndex = order.charAt(i)-'a';
            while(index[tempIndex]>0) {
                sb.append(order.charAt(i));
                index[tempIndex]--;
            }
        }
        for(int i=0; i<26; i++) {
            while(index[i]>0) {
                sb.append((char)('a'+i));
                index[i]--;
            }
        }
        return sb.toString();
    }
}