class Solution {
    // Logic
    // Split string by "/"
    // Take care of "..", ".", "" Strings
    // If !st.isEmpty() && temp.equals("..") --> st.pop()
    // If !temp.equals("" || "." || "..") --> st.push()
    public String simplifyPath(String path) {
      
        StringBuilder simplifyPath = new StringBuilder("");
        
        String[]splits = path.split("/");
        int N = splits.length;
        Stack<String> st = new Stack<>();
        for(int i=0; i<N; i++) {
        	if(!st.isEmpty() &&  splits[i].equals("..")) {
        		st.pop();
        	} else if(!splits[i].equals("") && 
                      !splits[i].equals("..") && 
                      !splits[i].equals(".")) {
        		st.push(splits[i]);
        	}
        }
        if(st.isEmpty()) {
        	return "/";
        }
        
        for(int i=0; i<st.size(); i++) {
        	simplifyPath.append("/");
        	simplifyPath.append(st.get(i));
        }
        return simplifyPath.toString();
    }
}