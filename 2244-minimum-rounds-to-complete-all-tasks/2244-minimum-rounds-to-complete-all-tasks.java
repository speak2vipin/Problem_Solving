class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int N = tasks.length;
        for(int i=0; i<N; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        int step = 0;
        
        for(Integer temp : map.keySet()) {
            int val = map.get(temp);
            if(val==1) {
            	return -1;
            }
            if(val%3==0) {
            		step += val/3;
            } else if(val%3==1) {
            		step += (val/3) - 1 + 2;
            } else {
            	step += (val/3)+1;            	
            }
        }
        return step;   
        
    }
}