class Solution {
    public double average(int[] salary) {
        int l = salary.length;
        int total = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        for(int s : salary) {
            minSalary = Math.min(minSalary, s);
            maxSalary = Math.max(maxSalary, s);
            total += s;
        }
        total = total - minSalary - maxSalary;
        
        return (double)total/(double)(l-2);
        
        
    }
}