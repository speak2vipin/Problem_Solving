class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=Math.min(9, n); i++) {
            generate(i, n, res);
        }
        return res;
    }
    
    private void generate(int curr, int limit, List<Integer> res) {
        if(curr>limit) {
            return;
        }
        res.add(curr);
        for(int nextDigit = 0; nextDigit<=9; nextDigit++) {
            int nextNumber = curr*10 + nextDigit;
            if(nextNumber<=limit) {
                generate(nextNumber, limit, res);
            } else {
                break;
            }
        }
    }
}