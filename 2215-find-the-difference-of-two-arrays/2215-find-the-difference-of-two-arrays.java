class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int constant = 1000;
       
        int []input1 = new int[2001];
        int []input2 = new int[2001];
        
        for(int num : nums1) {
            input1[constant+num] = 1;
        }
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums2) {
            input2[constant+num] = 1;
            if(input1[constant+num]==0) {
                list2.add(num);
                input1[constant+num] = 1;
            }
        }
        
        List<Integer> list1 = new ArrayList<>();
        for(int num : nums1) {
            if(input2[constant+num]==0) {
                list1.add(num);
                input2[constant+num] = 1;
            } 
        }
        
        ans.add(list1);
        ans.add(list2);
        
        return ans;
        
    }
}