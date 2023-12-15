class Solution {
    String ans = null;
    public String destCity(List<List<String>> paths) {
        
        Map<String, String> map = new HashMap<>();
        for(List<String> l : paths) {
            map.put(l.get(0), l.get(1));
        }
        traverse(paths.get(0).get(0), map);
        return ans;
    }
    
    void traverse(String city, Map<String, String> map) {
        if(map.get(city)==null) {
            ans = city;
            return;
        }
        traverse(map.get(city), map);
    }
}