class SmallestInfiniteSet {
    
    int [] numbers;
    int smallestPointer = 0;
    
    public SmallestInfiniteSet() {
        numbers = new int[1001];
        for(int i=1; i<1001; i++) {
            numbers[i] = 1;
        }
        smallestPointer = 1;
    }
    
    public int popSmallest() {
       // int i = 1;
        while(numbers[smallestPointer]==0) {
            smallestPointer++;
        }
        numbers[smallestPointer]--;
        return smallestPointer++;
    }
    
    public void addBack(int num) {
        if(numbers[num]==0) {
            numbers[num] = 1;
        }
        if(num < smallestPointer) {
            smallestPointer = num;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */