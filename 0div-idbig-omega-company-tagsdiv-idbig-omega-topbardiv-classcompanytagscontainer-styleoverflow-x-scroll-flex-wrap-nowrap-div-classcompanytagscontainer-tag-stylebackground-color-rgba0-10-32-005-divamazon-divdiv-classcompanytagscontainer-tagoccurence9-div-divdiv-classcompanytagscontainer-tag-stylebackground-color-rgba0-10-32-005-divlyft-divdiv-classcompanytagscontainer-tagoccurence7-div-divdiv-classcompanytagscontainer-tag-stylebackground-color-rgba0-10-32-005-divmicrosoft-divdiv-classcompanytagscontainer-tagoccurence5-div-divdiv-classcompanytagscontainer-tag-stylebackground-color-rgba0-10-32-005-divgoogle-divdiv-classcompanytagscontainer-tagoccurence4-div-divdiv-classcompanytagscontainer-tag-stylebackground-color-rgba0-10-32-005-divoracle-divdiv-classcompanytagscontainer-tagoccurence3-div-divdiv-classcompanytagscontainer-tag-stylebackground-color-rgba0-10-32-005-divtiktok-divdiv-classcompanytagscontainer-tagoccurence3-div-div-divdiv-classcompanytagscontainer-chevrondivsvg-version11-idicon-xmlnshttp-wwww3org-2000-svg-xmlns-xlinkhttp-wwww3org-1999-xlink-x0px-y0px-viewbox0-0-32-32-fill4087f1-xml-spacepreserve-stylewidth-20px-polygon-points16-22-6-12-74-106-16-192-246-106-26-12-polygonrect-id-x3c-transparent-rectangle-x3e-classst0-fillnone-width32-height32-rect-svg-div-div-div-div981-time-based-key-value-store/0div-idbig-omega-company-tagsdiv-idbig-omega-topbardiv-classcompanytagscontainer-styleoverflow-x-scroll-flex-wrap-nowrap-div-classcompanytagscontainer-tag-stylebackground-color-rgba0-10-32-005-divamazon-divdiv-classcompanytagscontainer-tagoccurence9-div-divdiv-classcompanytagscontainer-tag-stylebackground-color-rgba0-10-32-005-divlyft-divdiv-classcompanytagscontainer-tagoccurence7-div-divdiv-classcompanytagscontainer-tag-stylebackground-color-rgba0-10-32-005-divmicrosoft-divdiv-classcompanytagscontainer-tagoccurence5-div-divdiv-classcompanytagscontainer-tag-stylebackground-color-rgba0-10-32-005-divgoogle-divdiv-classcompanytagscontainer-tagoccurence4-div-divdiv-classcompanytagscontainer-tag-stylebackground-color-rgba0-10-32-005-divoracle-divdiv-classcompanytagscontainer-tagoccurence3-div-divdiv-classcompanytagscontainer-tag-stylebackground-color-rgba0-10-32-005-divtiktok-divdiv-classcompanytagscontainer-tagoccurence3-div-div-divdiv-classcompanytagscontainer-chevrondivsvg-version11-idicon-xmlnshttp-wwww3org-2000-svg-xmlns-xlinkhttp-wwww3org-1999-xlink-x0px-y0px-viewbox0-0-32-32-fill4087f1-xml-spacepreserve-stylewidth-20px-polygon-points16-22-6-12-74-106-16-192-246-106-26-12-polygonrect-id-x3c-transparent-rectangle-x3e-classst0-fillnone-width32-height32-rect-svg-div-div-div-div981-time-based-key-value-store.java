class TimeMap {
    
    private Map<String, List<Pair<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> list = store.get(key);
        if (list == null) {
            list = new ArrayList<>();
            store.put(key, list);
        }
        list.add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = store.get(key);
        if (list == null) {
            return "";
        }
        if (list.get(0).getKey() > timestamp) {
            return "";
        }

        int left = 0;
        int right = list.size();
        // binary search inside the 
        while (left < right) {
            int mid = (left + right) / 2;
            // this is the mplate condition part
            if (timestamp < list.get(mid).getKey()) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // `left` is the minimum k value which meets the condition, so we are looking for left - 1
        if (left == 0) {
            return "";
        }
        return list.get(left - 1).getValue();
    }
}
    


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */