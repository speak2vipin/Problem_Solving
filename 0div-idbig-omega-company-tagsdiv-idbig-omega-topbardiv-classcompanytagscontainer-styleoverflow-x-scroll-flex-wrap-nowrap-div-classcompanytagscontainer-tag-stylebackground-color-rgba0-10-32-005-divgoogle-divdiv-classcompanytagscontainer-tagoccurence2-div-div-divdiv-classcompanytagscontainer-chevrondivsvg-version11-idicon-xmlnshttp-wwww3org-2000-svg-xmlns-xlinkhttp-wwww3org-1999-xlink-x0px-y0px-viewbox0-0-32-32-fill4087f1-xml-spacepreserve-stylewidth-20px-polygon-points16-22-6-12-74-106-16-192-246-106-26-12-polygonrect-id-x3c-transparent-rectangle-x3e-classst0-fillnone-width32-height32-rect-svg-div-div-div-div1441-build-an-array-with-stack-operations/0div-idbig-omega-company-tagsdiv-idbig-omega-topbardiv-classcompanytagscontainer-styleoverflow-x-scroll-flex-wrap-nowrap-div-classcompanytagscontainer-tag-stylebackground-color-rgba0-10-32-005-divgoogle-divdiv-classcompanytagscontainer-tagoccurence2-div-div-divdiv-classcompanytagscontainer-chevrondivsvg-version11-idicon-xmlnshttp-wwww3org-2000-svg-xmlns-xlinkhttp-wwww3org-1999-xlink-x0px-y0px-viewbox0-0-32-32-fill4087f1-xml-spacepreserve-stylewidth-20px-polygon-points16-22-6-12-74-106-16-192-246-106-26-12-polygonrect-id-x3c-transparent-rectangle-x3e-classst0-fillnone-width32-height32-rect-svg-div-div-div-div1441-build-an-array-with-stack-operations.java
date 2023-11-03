class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int i=1;
        int index = 0;
        while(index<target.length) {
            if(target[index]==i) {
                ans.add("Push");
                index++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            i++;
        }
        return ans;
    }
}