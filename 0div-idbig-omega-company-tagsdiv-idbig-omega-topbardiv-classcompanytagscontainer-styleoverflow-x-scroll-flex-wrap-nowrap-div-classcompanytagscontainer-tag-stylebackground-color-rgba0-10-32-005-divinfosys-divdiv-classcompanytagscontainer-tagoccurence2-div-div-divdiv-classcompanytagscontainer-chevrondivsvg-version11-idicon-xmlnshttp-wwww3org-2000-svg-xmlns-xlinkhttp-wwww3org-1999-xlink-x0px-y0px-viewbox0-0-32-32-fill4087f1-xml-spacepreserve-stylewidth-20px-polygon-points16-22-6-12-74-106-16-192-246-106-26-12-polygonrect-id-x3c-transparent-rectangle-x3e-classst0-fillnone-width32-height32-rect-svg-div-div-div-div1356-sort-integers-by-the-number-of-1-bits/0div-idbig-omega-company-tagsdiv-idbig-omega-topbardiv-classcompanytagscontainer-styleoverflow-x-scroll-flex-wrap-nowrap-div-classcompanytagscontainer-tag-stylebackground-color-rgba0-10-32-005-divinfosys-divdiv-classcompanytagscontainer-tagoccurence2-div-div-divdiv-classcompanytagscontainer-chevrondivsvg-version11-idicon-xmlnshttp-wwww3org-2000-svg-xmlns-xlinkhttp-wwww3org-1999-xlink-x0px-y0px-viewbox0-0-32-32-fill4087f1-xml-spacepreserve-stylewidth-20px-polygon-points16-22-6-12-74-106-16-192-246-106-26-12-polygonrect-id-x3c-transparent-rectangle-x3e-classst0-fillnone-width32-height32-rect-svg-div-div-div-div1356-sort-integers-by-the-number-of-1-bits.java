class Solution {
    Map<Integer, Integer> map = null;
    public int[] sortByBits(int[] arr) {
        map = new HashMap<>();
        createCountMap();
        arr = Arrays.stream(arr)
            .boxed()
            .sorted((x,y)->map.get(x)==map.get(y) ? x-y : map.get(x) - map.get(y))
            .mapToInt(i->i)
            .toArray();
        
        return arr;
    }
    
    void createCountMap() {
        for(int i=0; i<10001; i++) {
            int num = i;
            int count = 0;
            for(int j=31; j>-1; j--) {
                count = count + ((i>>j)&1);
            }
            map.put(i, count);
        }
    }
}