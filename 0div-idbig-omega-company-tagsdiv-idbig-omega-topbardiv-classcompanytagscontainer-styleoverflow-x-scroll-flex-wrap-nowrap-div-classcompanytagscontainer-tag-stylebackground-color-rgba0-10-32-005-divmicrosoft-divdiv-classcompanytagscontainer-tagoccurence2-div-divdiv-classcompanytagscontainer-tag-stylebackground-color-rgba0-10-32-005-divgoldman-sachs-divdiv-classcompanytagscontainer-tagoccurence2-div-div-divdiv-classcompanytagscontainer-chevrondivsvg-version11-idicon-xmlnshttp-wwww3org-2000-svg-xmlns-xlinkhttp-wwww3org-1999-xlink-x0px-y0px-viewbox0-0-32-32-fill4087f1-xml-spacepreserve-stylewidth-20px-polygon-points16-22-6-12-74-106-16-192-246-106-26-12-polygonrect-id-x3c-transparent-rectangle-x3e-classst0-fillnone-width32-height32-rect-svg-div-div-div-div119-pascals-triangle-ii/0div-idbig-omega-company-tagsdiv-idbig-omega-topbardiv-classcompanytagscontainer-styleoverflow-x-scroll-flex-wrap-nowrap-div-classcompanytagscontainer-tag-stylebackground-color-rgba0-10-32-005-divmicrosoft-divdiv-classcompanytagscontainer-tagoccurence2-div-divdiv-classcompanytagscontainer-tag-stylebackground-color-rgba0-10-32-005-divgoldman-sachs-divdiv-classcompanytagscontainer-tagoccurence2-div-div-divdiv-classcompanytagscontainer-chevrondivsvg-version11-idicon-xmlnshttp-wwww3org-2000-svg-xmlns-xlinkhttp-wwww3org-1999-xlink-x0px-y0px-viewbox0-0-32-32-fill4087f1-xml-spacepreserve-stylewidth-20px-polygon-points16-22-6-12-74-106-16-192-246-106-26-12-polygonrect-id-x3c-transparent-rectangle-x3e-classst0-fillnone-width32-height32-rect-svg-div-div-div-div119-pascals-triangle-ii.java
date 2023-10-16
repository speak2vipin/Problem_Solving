class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex==0) {
            ans.add(1);
        } else {
            ans.add(1);
            ans.add(1);
            List<Integer> temp = null;
            for(int i=2; i<rowIndex+1; i++) {
                temp = new ArrayList<>();
                int size = ans.size();
                for(int j=0; j<size+1; j++) {
                    if(j==0 || j==size) {
                        temp.add(1);
                    } else {
                        temp.add(ans.get(j-1) + ans.get(j));
                    }
                }
                ans = temp;
            }
        }
        return ans;
    }
}