class Solution {
    public int totalFruit(int[] fruits) {
      
        int N = fruits.length;
        if(N<=2) {
            return N;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int j = 0;
        int i = 0;
        int ans = -1;
        int len = 0;
        while(j<N) {
            if(map.size()<2 || map.containsKey(fruits[j])) {
                map.put(fruits[j], map.getOrDefault(fruits[j], 0)+1);
                len = (j++)-i+1;
            } else {
                int existingFruit =  map.getOrDefault(fruits[i],0);
                if(existingFruit==1) {
                    map.remove(fruits[i]);
                } else {
                    map.put(fruits[i],existingFruit-1);
                }
                i++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    
    
    
    }
}