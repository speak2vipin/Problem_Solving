class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0;
        int j = 0;
        List<Integer> l = new ArrayList<>();
        while(i<l1 && j<l2) {
            if(nums1[i]==nums2[j]) {
                l.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i]<nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int res[] = new int[l.size()];
        for(int k=0; k<l.size(); k++) {
            res[k] = l.get(k);
        }
        return res; 
    }
}