class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tmap = map.getOrDefault(key, new TreeMap<Integer, String>());
        tmap.put(timestamp, value);
        map.put(key, tmap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tmap = map.get(key);
        if(tmap == null) return "";
        Map.Entry<Integer, String> entry = tmap.floorEntry(timestamp);
        if(entry == null) return "";
        return entry.getValue() == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */