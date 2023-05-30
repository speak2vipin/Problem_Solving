class MyHashSet {
    int input[] = null;

    public MyHashSet() {
        input = new int[1000001];
    }
    
    public void add(int key) {
        input[key] = 1;
    }
    
    public void remove(int key) {
        input[key] = 0;
    }
    
    public boolean contains(int key) {
        return input[key]!=0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */