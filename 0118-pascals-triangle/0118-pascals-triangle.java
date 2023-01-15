class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> prev = new ArrayList<Integer>();
        for(int i=0; i<numRows; i++) {
            List<Integer> ans = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    ans.add(1);
                } else {
                    ans.add(prev.get(j-1)+prev.get(j));
                }
                
            }
            result.add(ans);
            prev = ans;
        }
        return result;
        
    }
    
}