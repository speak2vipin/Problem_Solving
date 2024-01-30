class Solution {
    public int evalRPN(String[] tokens) {
        
        Set<String> set = new HashSet<>();
        set.add("/");
        set.add("+");
        set.add("-");
        set.add("*");
        Stack<String> st = new Stack<>();
        int n = tokens.length-1;
        for(int i=n; i>-1; i--) {
            if(set.contains(tokens[i])) {
                st.push(tokens[i]);
            } else if(st.isEmpty() || set.contains(st.peek())) {
                st.push(tokens[i]);
            } else {   
            	String operand1 = tokens[i];
                while(!st.isEmpty() && !set.contains(st.peek())) {
                	String operand2 = st.pop();
                    String Operator = st.pop();
                    String value = "";
                    switch(Operator) {
                        case "+": value += 
                        Integer.parseInt(operand1) + Integer.parseInt(operand2); 
                            break;
                        case "-": value +=  
                        Integer.parseInt(operand1) - Integer.parseInt(operand2); 
                            break;
                        case "*":
                            value +=  
                        Integer.parseInt(operand1) * Integer.parseInt(operand2);
                            break;
                        case "/":
                            value +=  
                    (Integer.parseInt(operand1) / Integer.parseInt(operand2));
                            break;
                        default:
                            break;
                    }
                    operand1 = value;
                    
                }
                st.push(operand1);
                
            }
        }
        return Integer.parseInt(st.pop());
        
    
    }
}