class Solution {
    public int minJumps(int[] arr) {
        // MUtiple Directional BFS problem
        Map<Integer, ArrayList<Integer>>valueToIndex = 
            new HashMap<Integer, ArrayList<Integer>>();
        int N = arr.length;
        if(N<=1) {
            return 0;
        }
       for(int i=0; i<N; i++) {
			valueToIndex.computeIfAbsent(arr[i], val-> new ArrayList<Integer>()).add(i);
        }
        int steps = 0;
        Queue<Integer> qe = new LinkedList<Integer> ();
        qe.offer(0);
        boolean[]visit = new boolean[N];
        visit[0] = true;
        while(!qe.isEmpty()) {
            int size = qe.size();
            for(int i=0; i<size; i++) {
                int index = qe.poll();
                if(index==N-1) {
                    return steps;
                }
                if(index+1<N && !visit[index+1]) {
                    qe.offer(index+1);
                    visit[index+1] = true;
                }
                if(index-1>-1 && !visit[index-1]) {
                    qe.offer(index-1);
                    visit[index-1] = true;
                }
                for(int sameNumber : valueToIndex.getOrDefault(arr[index], new ArrayList<Integer>())) {
                    if(!visit[sameNumber]){
                        qe.offer(sameNumber);
                        visit[sameNumber] = true;
                    }
                }
                // Take care of below line or else you will get TLE
                valueToIndex.remove(arr[index]);
            }
            steps++;
        }
       return -1; 
    }
}