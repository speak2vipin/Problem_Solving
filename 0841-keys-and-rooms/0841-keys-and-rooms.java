class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visit = new boolean[1000];
       
        List<Integer> l = rooms.get(0);
        Queue<Integer> qe = new LinkedList<Integer>();
        for(Integer i : l) {
            qe.add(i);
        }
        visit[0] = true;
        int max = maxRooms(rooms);
        while(!qe.isEmpty()) {
            int top = qe.poll();
            if(!visit[top]){
                List<Integer> temp = rooms.get(top);
                for(Integer num : temp) {
                    if(!qe.contains(num)) {
                        qe.add(num);
                    }
                }
            }
            visit[top] = true;
        }
        for(int i=0; i<=max; i++) {
            if(!visit[i]) {
                return false;
            }
        }
        return true;    
    }
    
    int maxRooms(List<List<Integer>> rooms) {
        int max = -1;
        for(List<Integer> room : rooms) {
            for(Integer num : room) {
                max = num > max ? num : max;
            }
        }
        return max;
    }
}