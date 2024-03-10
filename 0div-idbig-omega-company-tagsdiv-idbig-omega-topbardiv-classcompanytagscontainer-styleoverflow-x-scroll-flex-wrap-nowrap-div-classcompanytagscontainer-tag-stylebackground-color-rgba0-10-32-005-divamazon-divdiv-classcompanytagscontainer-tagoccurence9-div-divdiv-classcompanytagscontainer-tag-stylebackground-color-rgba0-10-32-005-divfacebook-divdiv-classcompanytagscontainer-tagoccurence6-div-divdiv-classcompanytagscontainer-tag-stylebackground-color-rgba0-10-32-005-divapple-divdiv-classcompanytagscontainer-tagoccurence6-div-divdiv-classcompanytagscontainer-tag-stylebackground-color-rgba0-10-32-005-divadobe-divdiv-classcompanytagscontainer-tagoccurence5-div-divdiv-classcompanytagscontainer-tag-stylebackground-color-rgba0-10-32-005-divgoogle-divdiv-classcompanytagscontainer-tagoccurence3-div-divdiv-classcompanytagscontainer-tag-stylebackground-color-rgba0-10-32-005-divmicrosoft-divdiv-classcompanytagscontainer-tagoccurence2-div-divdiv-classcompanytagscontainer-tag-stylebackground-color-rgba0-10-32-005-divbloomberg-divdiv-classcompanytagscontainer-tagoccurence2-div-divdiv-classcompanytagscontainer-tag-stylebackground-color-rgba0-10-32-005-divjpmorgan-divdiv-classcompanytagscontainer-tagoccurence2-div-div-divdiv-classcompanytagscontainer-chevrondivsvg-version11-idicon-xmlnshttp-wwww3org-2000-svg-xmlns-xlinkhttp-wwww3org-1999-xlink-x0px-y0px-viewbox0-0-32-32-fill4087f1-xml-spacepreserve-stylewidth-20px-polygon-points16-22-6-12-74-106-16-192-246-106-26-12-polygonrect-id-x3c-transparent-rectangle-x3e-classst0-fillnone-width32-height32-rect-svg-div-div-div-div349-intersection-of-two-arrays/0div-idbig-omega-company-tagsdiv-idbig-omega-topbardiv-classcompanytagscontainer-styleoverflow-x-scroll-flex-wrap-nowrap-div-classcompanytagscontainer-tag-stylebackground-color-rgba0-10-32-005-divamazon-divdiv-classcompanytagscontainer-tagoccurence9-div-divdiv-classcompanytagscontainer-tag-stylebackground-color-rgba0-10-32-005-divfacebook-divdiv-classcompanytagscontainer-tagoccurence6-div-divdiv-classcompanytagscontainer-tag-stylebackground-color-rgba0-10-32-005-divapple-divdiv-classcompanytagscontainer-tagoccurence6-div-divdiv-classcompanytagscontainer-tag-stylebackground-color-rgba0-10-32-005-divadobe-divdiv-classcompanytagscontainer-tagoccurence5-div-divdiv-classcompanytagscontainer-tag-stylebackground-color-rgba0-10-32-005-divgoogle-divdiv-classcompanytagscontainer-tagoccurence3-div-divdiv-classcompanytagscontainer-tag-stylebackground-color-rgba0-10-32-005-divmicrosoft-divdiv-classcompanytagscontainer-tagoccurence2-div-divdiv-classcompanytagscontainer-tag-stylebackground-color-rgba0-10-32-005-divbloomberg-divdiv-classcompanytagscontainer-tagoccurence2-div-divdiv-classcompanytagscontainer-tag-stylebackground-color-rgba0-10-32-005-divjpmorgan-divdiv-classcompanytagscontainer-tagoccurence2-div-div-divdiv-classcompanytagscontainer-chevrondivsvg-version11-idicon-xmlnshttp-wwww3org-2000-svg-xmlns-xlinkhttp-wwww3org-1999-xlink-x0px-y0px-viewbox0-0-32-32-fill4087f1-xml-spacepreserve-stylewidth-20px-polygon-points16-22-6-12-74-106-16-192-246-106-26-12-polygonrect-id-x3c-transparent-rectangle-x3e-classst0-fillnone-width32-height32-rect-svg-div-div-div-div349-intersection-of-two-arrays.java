class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //HashSet<Integer> set = new HashSet<>();
        
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> resultSet = new HashSet<>();
        return Arrays.stream(nums2)
                     .filter(set::contains)
                     .filter(resultSet::add)
                     .toArray();
        
    }
}