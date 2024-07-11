class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i<s.length()) {
            if(s.charAt(i)==')') {
                int st = stack.pop();
                s = s.substring(0, st) 
                    + new StringBuilder(s.substring(st+1, i)).reverse().toString() 
                    + s.substring(i+1, s.length());
                i--;
                continue;
            } else if(s.charAt(i)=='(') {
                stack.push(i);
            }
            i++;
        }
        return s;
        
    }
    
    
}




