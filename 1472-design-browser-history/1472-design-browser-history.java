class BrowserHistory {
    Stack<String> forward;
    Stack<String> backward;
    public BrowserHistory(String homepage) {
        forward = new Stack<>();
        forward.push(homepage);
        backward = new Stack<>();
    }
    
    public void visit(String url) {
        if(!backward.isEmpty()) {
            backward.clear();
        }
        //backward.push()
        forward.push(url);
    }
    
    public String back(int steps) {
        String url = null;
        while(forward.size()>1 && steps-- > 0 ){
            url = forward.pop();
            backward.push(url);
        }
    
        return forward.peek();
    }
    
    public String forward(int steps) {
        String url = null;
        if(backward.isEmpty()) {
            url = forward.peek();
        } else {
            while(!backward.isEmpty() && steps-- > 0 ){
                url = backward.pop();
                forward.push(url);
            }
        }
        return url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */