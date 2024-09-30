class CustomStack {
    Stack<Integer>st1 = null;
    Stack<Integer>st2 = null;
    int maxSize = -1;

    public CustomStack(int maxSize) {
        st1 = new Stack<>();
        st2 = new Stack<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(st1.size()<maxSize) {
            st1.push(x);
        }
    }
    
    public int pop() {
        if(st1.size()==0) {
            return -1;
        }
        return st1.pop();
    }
    
    public void increment(int k, int val) {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        
        while(!st2.isEmpty()) {
            int num = st2.pop();
            if(k>0)
                num = num+val;
            st1.push(num);
            k--;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */