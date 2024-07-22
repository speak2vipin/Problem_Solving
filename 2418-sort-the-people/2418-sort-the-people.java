class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Integer[]index = new Integer[len];
        for(int i=0; i<len; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i1,i2)->Integer.compare(heights[i2], heights[i1]));
        String res[] = new String[len];
        for(int i=0; i<len; i++) {
            res[i] = names[index[i]];
        }
        return res;
    }
}