class Solution {
    public String reverseParenthesesByMe(String s) {
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
    
    String reverseParentheses(String s) {
        // Wormhole Teleportation technique
        int n = s.length();
        Stack<Integer> openParanthesisIndices = new Stack<>();
        int pair[] = new int[n];
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='(') {
                openParanthesisIndices.push(i);
            } else if(s.charAt(i)==')') {
                int j = openParanthesisIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int currI = 0, direction = 1; currI<n; currI+=direction) {
            if(s.charAt(currI)=='(' || s.charAt(currI)==')') {
                currI = pair[currI];
                direction = -direction;
            } else {
                result.append(s.charAt(currI));
            }
        }
        return result.toString();
    }
    
    
}




