class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; startFuel < target; res++) {
            while (i < stations.length && stations[i][0] <= startFuel)
                pq.offer(-stations[i++][1]);
            if (pq.isEmpty()) return -1;
            startFuel += -pq.poll();
        }
        return res;
    }
}