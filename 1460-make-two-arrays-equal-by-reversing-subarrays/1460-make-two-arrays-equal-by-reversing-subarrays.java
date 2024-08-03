class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int t : target) {
            targetMap.put(t, targetMap.getOrDefault(t, 0)+1);
        }
        for(int a : arr) {
            if(targetMap.get(a)==null || targetMap.get(a)==0) {
                return false;
            }
            targetMap.put(a, targetMap.get(a)-1);
        }
        return true;
    }
}