class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add(1l);
        Long smallest = 0l;
        for(int i=1; i<n+1; i++) {
            smallest = treeSet.pollFirst();
            treeSet.add(smallest*2);
            treeSet.add(smallest*3);
            treeSet.add(smallest*5);
        }
        return smallest.intValue();
    }
}