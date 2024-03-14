class Solution {
    public int maximumValue(String[] strs) {
        int val = Integer.MIN_VALUE;
        for(String s : strs) {
            int temp = Integer.MIN_VALUE;
            try {
                temp = Integer.parseInt(s);
            } catch(NumberFormatException nfe) {
                temp = Math.max(temp, s.length());
            }
            val = Math.max(val, temp);
        }
        return val;
        
    }
}