class MyHashMap {
    int input[] = null;
    int mod = 1000001;
    
    public MyHashMap() {
        input = new int[1000001];
        Arrays.fill(input, -1);
    }
    
    public void put(int key, int value) {
        input[key] = value;
    }
    
    public int get(int key) {
        return input[key];
    }
    
    public void remove(int key) {
        input[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */