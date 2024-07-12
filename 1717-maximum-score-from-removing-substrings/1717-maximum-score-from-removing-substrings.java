class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x>y?"ab":"ba";
        String lowPriorityPair = x>y?"ba":"ab";
        
        String afterFirstPass = remoevXAndY(s, highPriorityPair);
        int removePairCount = (s.length() - afterFirstPass.length())/2;
        totalScore += removePairCount * Math.max(x, y);
        
        String afterSecondPass = remoevXAndY(afterFirstPass, lowPriorityPair);
        removePairCount = (afterFirstPass.length() - afterSecondPass.length())/2;
        totalScore += removePairCount * Math.min(x, y);
        return totalScore;
        
    }
    
    String remoevXAndY(String s, String pair) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar==pair.charAt(1) && !st.isEmpty() && st.peek()==pair.charAt(0)) {
                st.pop();
            } else {
                st.push(currentChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}