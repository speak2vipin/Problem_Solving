class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int a : arr1) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int i = 0;
        for(int a : arr2) {
            while(map.get(a)!=null) {
                arr1[i++] = a;
                if(map.get(a)==1) {
                    map.remove(a);
                } else {
                    map.put(a, map.get(a)-1);
                }
            }
        }
        for(Integer key : map.keySet()) {
            int val = map.get(key);
            while(val>0) {
                arr1[i++] = key;
                val--;
            }
        }
        return arr1;
        
    }
}