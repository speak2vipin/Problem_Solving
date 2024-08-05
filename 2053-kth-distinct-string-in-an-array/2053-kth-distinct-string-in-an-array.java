class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> l = new ArrayList<>();
        Set<String> exisiting = new HashSet<>();
        
        for(String s : arr) {
            if(!exisiting.contains(s)) {
                l.add(s);
            } else {
                l.remove(s);
            }
            exisiting.add(s);
        }
        return l.size()<k ? "" : l.get(k-1);
    }
}