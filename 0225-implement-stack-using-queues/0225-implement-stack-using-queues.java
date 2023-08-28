class MyStack {
    Queue<Integer> q1 = null;
    Queue<Integer> q2 = null;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }
    
    public int pop() {
        int value = -1;
        if(!empty()) {
            if(q1.isEmpty()) {
               int size = q2.size();
               for(int i=0; i<size; i++) {
                   value = q2.poll(); 
                   if(i<size-1) {
                      q1.offer(value);
                   }
               }
            } else {
               int size = q1.size();
               for(int i=0; i<size; i++) {
                   value = q1.poll(); 
                   if(i<size-1) {
                      q2.offer(value);
                   }
               }
            }
        }
        return value;
    }
    
    public int top() {
        int value = -1;
        if(!empty()) {
            if(q1.isEmpty()) {
               int size = q2.size();
               for(int i=0; i<size; i++) {
                   value = q2.poll(); 
                   q1.offer(value);
               }
            } else {
               int size = q1.size();
               for(int i=0; i<size; i++) {
                   value = q1.poll(); 
                   q2.offer(value);
               }
            }
        }
        return value;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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