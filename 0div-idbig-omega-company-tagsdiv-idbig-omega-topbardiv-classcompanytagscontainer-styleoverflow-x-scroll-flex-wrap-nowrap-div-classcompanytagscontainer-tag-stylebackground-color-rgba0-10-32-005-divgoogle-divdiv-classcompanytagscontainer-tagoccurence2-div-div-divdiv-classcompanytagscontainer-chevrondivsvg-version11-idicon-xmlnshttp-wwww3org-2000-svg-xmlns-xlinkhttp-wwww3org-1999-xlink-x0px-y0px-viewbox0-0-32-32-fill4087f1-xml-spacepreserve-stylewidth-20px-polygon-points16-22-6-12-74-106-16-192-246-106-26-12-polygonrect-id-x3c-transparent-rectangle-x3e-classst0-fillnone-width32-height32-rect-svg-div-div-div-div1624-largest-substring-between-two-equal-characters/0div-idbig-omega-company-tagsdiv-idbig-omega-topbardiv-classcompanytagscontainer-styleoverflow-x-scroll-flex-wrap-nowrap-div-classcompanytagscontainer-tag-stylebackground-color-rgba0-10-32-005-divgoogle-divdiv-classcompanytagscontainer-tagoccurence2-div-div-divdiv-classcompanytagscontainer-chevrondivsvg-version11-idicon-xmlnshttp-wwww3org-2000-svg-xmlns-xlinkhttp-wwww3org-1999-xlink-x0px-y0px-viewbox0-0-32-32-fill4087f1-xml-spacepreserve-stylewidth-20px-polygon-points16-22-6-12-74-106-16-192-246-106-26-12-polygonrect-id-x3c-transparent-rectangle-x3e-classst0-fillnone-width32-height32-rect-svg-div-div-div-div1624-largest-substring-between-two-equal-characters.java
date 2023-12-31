class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int index[] = new int[26];
        int ans = -1;
        Arrays.fill(index, -1);
        for(int i=0; i<s.length(); i++) {
            if(index[s.charAt(i)-'a']==-1) {
                index[s.charAt(i)-'a'] = i;
            } else {
                ans = Math.max(ans, i-index[s.charAt(i)-'a']-1);
            }
        }
        return ans;
    }
}