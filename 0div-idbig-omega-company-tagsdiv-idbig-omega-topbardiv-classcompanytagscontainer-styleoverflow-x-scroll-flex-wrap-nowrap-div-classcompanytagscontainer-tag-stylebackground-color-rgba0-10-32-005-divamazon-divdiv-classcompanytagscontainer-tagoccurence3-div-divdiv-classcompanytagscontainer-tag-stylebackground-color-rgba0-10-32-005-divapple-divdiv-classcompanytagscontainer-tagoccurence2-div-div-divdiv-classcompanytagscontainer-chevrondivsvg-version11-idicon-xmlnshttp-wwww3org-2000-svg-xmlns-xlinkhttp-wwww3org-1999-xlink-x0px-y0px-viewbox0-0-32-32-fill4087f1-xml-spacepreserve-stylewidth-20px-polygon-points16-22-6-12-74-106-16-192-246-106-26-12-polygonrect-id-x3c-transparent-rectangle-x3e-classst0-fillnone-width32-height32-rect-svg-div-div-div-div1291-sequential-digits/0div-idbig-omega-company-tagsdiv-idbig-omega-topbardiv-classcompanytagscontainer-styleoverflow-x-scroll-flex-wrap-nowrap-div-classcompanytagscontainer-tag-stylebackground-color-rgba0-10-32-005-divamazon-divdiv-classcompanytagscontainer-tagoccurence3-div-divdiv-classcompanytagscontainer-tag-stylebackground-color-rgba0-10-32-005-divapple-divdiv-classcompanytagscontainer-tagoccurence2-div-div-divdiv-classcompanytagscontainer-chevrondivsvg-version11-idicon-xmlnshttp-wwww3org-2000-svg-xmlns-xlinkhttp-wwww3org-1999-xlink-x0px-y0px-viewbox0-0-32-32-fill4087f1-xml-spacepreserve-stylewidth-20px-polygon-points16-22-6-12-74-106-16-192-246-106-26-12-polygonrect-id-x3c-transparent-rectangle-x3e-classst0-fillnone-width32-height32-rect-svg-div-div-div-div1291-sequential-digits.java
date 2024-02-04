class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> qe= new LinkedList<>();
        for(int i=1; i<10; i++) {
            qe.offer(i);
        }
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(top>=low && top<=high) {
                res.add(top);
            }
            int lastDigit = top%10;
            top = (top*10) + lastDigit + 1;
            // Take of lastDisit<9 constraint as it will spoil sequence
            // 90 + 9 + 1 = 100 -> which will disturbed our sequence
            if(lastDigit<9 && top<=high) {
                qe.offer(top);
            }
        }
        return res;
    }
    
}