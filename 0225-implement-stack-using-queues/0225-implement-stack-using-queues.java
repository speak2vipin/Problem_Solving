class MyStack {
    Queue<Integer> q1 = null;
    Queue<Integer> q2 = null;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        int value = -1;
        
        if(!q1.isEmpty()) {
            int size = q1.size();
            for(int i=0; i<size; i++) {
                value = q1.poll(); 
                if(i<size-1) {
                    q2.offer(value);
                }
            }
            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;
        }
        return value;
    }
    
    public int top() {
        int value = -1;
        if(!q1.isEmpty()) {
            int size = q1.size();
            for(int i=0; i<size; i++) {
                value = q1.poll(); 
                q2.offer(value);
            }
            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;
        } 
        return value;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */