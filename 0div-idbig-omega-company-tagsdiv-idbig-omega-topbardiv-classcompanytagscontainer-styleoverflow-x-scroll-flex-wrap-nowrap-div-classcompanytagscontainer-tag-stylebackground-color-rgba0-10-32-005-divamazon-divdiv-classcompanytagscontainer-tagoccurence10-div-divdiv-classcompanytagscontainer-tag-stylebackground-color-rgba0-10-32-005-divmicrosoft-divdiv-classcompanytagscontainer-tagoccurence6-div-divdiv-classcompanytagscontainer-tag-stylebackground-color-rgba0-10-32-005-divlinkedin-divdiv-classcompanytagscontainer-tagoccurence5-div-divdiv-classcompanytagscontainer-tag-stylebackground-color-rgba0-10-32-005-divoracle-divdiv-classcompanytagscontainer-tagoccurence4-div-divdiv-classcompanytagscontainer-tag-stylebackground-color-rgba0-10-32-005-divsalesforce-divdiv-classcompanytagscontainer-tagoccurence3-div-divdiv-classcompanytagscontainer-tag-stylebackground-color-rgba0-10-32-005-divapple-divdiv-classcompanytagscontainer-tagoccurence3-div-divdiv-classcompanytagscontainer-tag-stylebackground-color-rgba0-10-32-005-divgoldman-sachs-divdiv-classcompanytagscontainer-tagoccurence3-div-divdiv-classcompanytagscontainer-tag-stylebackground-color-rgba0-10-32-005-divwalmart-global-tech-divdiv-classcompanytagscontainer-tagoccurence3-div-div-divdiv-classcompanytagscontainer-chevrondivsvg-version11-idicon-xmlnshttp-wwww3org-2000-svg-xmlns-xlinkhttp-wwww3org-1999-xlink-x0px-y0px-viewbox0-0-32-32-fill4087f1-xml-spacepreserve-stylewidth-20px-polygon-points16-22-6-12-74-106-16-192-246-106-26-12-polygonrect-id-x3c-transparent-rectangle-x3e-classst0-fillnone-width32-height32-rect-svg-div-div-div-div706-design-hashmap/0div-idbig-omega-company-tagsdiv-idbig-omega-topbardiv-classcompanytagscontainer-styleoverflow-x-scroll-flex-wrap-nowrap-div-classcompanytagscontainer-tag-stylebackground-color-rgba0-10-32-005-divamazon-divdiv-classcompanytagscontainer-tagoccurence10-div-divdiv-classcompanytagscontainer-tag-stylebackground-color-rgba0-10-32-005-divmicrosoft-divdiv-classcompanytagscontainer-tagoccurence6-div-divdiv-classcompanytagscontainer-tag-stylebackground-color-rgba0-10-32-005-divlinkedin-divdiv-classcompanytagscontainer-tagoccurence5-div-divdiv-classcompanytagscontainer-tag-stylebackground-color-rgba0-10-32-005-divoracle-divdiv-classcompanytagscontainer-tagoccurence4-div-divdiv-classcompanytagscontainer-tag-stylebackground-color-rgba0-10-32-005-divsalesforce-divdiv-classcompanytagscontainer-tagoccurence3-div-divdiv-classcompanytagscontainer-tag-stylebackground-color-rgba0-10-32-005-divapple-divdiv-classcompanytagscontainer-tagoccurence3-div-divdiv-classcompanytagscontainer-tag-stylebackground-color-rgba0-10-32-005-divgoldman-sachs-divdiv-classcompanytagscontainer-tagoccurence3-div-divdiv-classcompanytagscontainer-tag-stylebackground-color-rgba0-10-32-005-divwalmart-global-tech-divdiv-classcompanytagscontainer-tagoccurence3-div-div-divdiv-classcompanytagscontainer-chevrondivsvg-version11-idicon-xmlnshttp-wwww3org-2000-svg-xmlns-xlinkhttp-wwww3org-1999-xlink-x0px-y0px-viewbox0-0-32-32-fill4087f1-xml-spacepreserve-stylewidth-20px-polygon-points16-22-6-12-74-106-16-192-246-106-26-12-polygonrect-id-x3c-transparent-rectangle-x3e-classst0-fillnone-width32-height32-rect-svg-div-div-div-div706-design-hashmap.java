class MyHashMap {
    //int input[] = null;
    //int mod = 1000001;
    
    LinkedList<Entry>[] buckets;
    int size = 1000;
    public MyHashMap() {
       buckets = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int index = key%size;
        LinkedList<Entry> list = buckets[index];
        if(list==null) {
            list = new LinkedList<>();
        } else {
            for(Entry e : list) {
                if(e.key==key) {
                    e.value = value;
                    return;
                }
            }
        }
        list.add(new Entry(key, value));
        buckets[index] = list;
    }
    
    public int get(int key) {
        int index = key%size;
        int val = -1;
        LinkedList<Entry> list = buckets[index];
        if(list!=null) {
            for(Entry e : list) {
                if(e.key==key) {
                    val = e.value;
                    break;
                }
            }
        }
        return val;
    }
    
    public void remove(int key) {
        int index = key%size;
        LinkedList<Entry> list = buckets[index];
        Entry obslete = null;
        if(list==null) {
            return;
        } else {
            for(Entry e : list) {
                if(e.key==key) {
                    obslete = e;
                    break;
                }
            }
        }
        if(obslete!=null) {
            list.remove(obslete);
        }
    }
}

class Entry {
    int key;
    int value;
    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */