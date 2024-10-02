class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        Map<Integer, Integer> numToRank = new HashMap<>();
        
       /* for(int i=0; i<n; i++) {
            if(!pq.contains(arr[i]))
                pq.offer(arr[i]);
        }
        
        int count = 1;
        while(!pq.isEmpty()) {
            index.put(pq.poll(), count++);
        }
        
        int res[] = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = index.get(arr[i]);
            
        }
        return res;*/
        
        TreeSet<Integer> sortedNums = new TreeSet<>();
        for(int a : arr) {
            sortedNums.add(a);
        }
        int rank = 1;
        for(Integer num : sortedNums) {
            numToRank.put(num, rank++);
        }
        int res[] = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = numToRank.get(arr[i]);
            
        }
        return res;
        
        
    }
}