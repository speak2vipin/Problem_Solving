class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        // Create frequency Map of arr1 array
        for(int a : arr1) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int i = 0;
        // Place elements in the front according to order in arr2
        for(int a : arr2) {
            // Place all repetive numbers if it is there
            while(map.get(a)!=null) {
                arr1[i++] = a;
                if(map.get(a)==1) {
                    map.remove(a);
                } else {
                    map.put(a, map.get(a)-1);
                }
            }
        }
        // Place all the remaining number in the arr1
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