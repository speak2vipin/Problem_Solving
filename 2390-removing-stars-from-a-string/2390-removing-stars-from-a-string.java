class Solution {
    public String removeStars(String s) {
        
        int L = s.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<L) {
            char temp = s.charAt(i);
            if(temp=='*' && !st.isEmpty()) {
                st.pop();
            } else {
                st.push(temp);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for(Character c : st) {
            sb.append(c);
        }
        return sb.toString(); 
    
        
    }
}