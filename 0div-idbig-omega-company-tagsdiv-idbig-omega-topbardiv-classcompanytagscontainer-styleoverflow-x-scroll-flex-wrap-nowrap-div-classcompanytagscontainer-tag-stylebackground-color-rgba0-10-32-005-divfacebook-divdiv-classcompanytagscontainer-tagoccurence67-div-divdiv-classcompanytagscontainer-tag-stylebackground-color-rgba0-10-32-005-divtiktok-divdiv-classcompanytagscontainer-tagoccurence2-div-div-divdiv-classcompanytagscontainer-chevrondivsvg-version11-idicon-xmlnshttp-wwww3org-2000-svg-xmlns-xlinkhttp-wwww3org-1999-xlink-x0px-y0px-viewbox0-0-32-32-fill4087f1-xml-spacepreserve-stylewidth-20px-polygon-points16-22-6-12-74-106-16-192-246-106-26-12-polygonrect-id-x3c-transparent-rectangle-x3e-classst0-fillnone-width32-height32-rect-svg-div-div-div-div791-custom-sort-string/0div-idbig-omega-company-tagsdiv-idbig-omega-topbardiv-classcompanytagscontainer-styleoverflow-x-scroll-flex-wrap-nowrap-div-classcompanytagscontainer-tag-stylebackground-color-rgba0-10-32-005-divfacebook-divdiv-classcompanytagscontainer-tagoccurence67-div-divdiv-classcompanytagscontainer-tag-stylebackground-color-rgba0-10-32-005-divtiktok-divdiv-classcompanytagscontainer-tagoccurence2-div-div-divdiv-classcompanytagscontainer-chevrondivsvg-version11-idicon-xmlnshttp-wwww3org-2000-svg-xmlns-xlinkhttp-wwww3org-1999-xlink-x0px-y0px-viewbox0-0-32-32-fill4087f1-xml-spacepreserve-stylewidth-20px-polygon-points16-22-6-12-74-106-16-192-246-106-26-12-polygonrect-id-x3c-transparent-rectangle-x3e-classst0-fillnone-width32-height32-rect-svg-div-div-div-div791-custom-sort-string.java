class Solution {
    public String customSortString(String order, String s) {
        int countS[] = new int[26];
        for(int i=0; i<s.length(); i++) {
            countS[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            int index = order.charAt(i)-'a';
            while(countS[index]>0) {
                sb.append(order.charAt(i));
                countS[index]--;
            }
        }
        for(int i=0; i<26; i++) {
            while(countS[i]>0) {
                sb.append((char)('a'+i));
                countS[i]--;
            }
        }
        return sb.toString();
    }
}