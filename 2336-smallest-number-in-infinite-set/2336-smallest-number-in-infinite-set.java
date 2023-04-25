class SmallestInfiniteSet {
    
    int [] numbers;
    
    public SmallestInfiniteSet() {
        numbers = new int[1001];
        for(int i=1; i<1001; i++) {
            numbers[i] = 1;
        }
    }
    
    public int popSmallest() {
        int i = 1;
        while(numbers[i]==0) {
            i++;
        }
        numbers[i]--;
        return i;
    }
    
    public void addBack(int num) {
        if(numbers[num]==0) {
            numbers[num] = 1;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */