class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        
        for(int i=0; i<N; i++) {
            if(gas[i]!=0 && gas[i]>=cost[i]) {
                if(check(N, i, gas, cost)) {
                    return i;
                }
            } 
        }
        return -1;
    }
    
    boolean check(int L, int index, int[] gas, int[] cost) {  
        int step=0;
        int remainingGas = 0;
        while(step<L && remainingGas>-1) {
            if(index==L-1) {
                remainingGas += gas[index] - cost[index];
                step++;
                index=0;
                continue;
            } else {
                remainingGas += gas[index] - cost[index];
                step++;
                index++;
            }
        }
        return (step==L && remainingGas>-1) ? true : false;
    }
}