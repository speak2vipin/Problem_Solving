class Solution {
    public int kthFactorWithSpaceComplexity(int n, int k) {
        Set<Integer> factors = new TreeSet<>();
        for(int i=1; i*i<=n; i++) {
            if((n%i)==0) {
                factors.add(i);
                factors.add(n/i);
            }
        }
        List<Integer> result = new ArrayList<>(factors);
        return result.size()<k?-1:result.get(k-1);
    }
    
    public int kthFactor(int n, int k) {
        //Set<Integer> factors = new TreeSet<>();
        for(int i=1; i<=n; i++) {
            if((n%i)==0) {
                k--;
                if(k==0) {
                    return i;
                }
            }
        }
        //List<Integer> result = new ArrayList<>(factors);
        return -1;
    }
}