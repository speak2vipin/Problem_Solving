class Solution {
    public String largestNumber(int[] nums) {
        String result = "";
        int numsTemp[] = new int[nums.length];
        String [] strArray = new String[nums.length];
        for(int i =0; i<nums.length;i++) {
            strArray[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strArray, new NumberComparator());
        if(Integer.parseInt(strArray[0])==0) {
            return "0";
        } else {
            for(int i =0; i<nums.length;i++) {
                result+=strArray[i]; 
             }
        }
        return result;
    }
        
    private class NumberComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String temp1 = s1+s2;
            String temp2 = s2+s1;
            return temp2.compareTo(temp1);
        }
    }
        
        
        
    
    
}