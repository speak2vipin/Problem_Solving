class Solution {
    public int kthFactor(int n, int k) {
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
}