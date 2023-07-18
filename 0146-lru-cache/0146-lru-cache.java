class LRUCache {
    Map<Integer, Node> map = null;
    Node head = null;
    Node tail = null;
    int capacity = -1;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
     public int get(int key) {
        Node curr = map.get(key);
        if(curr==null) {
            return -1;
        }
        int val = curr.val;
        map.remove(key);
        if(head==tail) {
            head = null;
            tail = null;
        } else if(curr.prev!=null) {
            curr.prev.next = curr.next;
            if(curr.next!=null) {
                curr.next.prev = curr.prev;
            } else {
                head = curr.prev;
            }
        } else if(curr.prev==null && curr.next!=null) {
            tail = tail.next;
            tail.prev = null;
        }
        add(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        
        add(key, value); 
        if(map.size()>capacity) {
            delete();
        }
    }
    
    public void add(int key, int value) {
        Node curr = null;
        if(map.get(key)!=null) {
        	curr = map.get(key);
            map.remove(key);
            if(head==tail) {
                head = null;
                tail = null;
            } else if(curr.prev!=null) {
                curr.prev.next = curr.next;
                if(curr.next!=null) {
                    curr.next.prev = curr.prev;
                } else {
                	head = curr.prev;
                }
            } else if(curr.prev==null && curr.next!=null) {
                tail = tail.next;
                tail.prev = null;
            };
        }
        if(head==null) {
            curr = new Node(null, null, key, value);
            head = curr;
            tail = curr;
        } else {
            curr = new Node(null, head, key, value);
            head.next = curr;
            head = head.next;
        }
        map.put(key, curr);
    }
    
    public void delete() {
        map.remove(tail.key);
        tail = tail.next;
        if(tail!=null)
            tail.prev = null;
        else {
            head = null;
        }
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;
    
    public Node(Node next, Node prev, int key, int val) {
        this.next = next;
        this.prev = prev;
        this.key = key;
        this.val = val;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */