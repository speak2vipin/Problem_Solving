class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> ban = new HashSet<>();
        for(String b : bannedWords) {
            ban.add(b);
        }
        int count = 0;
        for(String m : message) {
            if(ban.contains(m)) {
                count++;
            }
        }
        return count>=2;
    }
}