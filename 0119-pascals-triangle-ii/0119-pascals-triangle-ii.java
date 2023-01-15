class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<=rowIndex; i++) {
            List<Integer> prev = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    prev.add(1);
                } else {
                    prev.add(result.get(j-1)+result.get(j));
                }
            }
            result = prev;
        }
        return result;
    }
}