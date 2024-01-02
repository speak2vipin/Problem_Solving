class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        List<Integer> discard = new ArrayList<>();
        int size = freq.size();
        while(discard.size()<size) {
            List<Integer> temp = new ArrayList<>();
            for(Integer key : freq.keySet()) {
                if(!temp.contains(key) && freq.get(key)>0) {
                    temp.add(key);
                    if(freq.get(key)==1) {
                        discard.add(key);
                    } 
                    freq.put(key, freq.get(key)-1);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}