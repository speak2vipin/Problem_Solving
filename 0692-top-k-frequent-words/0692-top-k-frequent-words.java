class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> queue = new PriorityQueue<String>(
          (n1, n2) -> map.get(n1) ==  map.get(n2) ?
              n1.compareTo(n2) : map.get(n2) - map.get(n1));
    
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        for(String s :  map.keySet()) {
            queue.add(s);
        }
        List<String> ans = new ArrayList<String>();
        while(k>0) {
            ans.add(queue.poll());
            k--;
        }
        return ans;
    }
}