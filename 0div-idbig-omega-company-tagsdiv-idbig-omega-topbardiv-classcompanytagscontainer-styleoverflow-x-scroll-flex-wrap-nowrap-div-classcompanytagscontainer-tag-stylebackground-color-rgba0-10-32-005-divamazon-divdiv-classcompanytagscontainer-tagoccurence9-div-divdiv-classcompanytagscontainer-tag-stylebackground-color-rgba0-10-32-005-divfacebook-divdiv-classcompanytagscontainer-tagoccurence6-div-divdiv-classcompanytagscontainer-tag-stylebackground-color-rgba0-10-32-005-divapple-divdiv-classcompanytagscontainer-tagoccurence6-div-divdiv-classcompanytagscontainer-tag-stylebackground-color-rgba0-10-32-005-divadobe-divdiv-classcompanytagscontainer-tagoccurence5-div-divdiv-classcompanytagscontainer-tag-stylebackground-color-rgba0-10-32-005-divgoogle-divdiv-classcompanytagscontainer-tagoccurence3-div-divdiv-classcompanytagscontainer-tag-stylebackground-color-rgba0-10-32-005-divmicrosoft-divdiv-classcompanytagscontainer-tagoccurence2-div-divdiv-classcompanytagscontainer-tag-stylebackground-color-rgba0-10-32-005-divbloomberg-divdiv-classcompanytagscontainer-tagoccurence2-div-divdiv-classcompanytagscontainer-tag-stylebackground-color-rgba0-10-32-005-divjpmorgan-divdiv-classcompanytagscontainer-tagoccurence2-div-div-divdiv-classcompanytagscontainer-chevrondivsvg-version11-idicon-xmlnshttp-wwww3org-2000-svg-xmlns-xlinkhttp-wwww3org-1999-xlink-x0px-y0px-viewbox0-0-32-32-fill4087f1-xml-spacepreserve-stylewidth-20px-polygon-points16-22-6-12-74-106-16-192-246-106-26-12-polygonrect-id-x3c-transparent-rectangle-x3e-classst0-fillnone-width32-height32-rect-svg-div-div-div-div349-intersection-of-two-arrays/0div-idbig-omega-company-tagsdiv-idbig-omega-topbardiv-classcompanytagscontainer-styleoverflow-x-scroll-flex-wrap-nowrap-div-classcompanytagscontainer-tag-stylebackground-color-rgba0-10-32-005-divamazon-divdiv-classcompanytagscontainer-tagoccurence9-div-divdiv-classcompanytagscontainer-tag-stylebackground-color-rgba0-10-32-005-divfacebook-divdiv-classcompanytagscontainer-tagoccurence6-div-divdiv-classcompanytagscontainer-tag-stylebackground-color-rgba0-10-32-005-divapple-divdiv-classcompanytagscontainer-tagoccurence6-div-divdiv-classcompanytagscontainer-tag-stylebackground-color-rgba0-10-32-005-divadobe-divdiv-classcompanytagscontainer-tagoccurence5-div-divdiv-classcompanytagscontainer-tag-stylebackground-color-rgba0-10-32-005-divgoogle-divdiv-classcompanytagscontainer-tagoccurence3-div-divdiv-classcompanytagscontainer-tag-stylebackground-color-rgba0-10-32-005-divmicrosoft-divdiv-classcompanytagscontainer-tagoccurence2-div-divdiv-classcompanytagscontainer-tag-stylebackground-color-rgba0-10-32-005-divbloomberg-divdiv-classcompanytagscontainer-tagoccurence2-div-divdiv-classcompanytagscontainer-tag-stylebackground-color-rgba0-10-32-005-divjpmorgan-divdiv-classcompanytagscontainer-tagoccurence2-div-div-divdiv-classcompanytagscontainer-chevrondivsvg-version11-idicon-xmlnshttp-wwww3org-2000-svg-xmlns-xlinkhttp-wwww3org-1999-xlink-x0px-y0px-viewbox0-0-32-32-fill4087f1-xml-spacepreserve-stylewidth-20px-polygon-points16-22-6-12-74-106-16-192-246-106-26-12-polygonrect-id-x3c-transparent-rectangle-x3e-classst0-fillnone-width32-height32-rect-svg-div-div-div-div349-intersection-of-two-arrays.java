class Solution {
    /*public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> resultSet = new HashSet<>();
        return Arrays.stream(nums2)
                     .filter(set::contains)
                     .filter(resultSet::add)
                     .toArray();
        
    }*/
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        Set<Integer>resultSet = new HashSet<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                resultSet.add(num);
            }
        }
        int result[] = new int[resultSet.size()];
        int index = 0;
        for(Integer val : resultSet) {
            result[index++] = val;
        }
        return result;
    }
}