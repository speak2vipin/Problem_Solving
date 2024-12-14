class ProductOfNumbers {
    ArrayList<Integer> stream = null;
    
    public ProductOfNumbers() {
        stream = new ArrayList<>();
        stream.add(1);
    }
    
    public void add(int num) {
        int value = 1;
        if(num==0) {
            stream = new ArrayList<>();
        } else {
            value = stream.get(stream.size()-1)*num;
        }
        stream.add(value);
    }
    
    public int getProduct(int k) {
        if(k<stream.size()) {
            return stream.get(stream.size()-1)/ stream.get(stream.size()-1-k);
        } else {
            return 0;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */