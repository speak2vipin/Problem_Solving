class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int L = s.length();
        for(int i=0; i<L; i++) {
            char temp = s.charAt(i);
            if((temp=='(') || (temp=='{') || (temp=='[')) {
                st.push(temp);
            } else {
                if(st.isEmpty() || (!isMatching(st, temp))) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
	boolean isMatching(Stack<Character>st, char temp) {
		char top = st.pop();
		if(temp==')') {
			return top=='(';
		} else if(temp == '}') {
			return top=='{';
		} else if(temp== ']') {
			return top=='[';
		}
		return false;
	}
}