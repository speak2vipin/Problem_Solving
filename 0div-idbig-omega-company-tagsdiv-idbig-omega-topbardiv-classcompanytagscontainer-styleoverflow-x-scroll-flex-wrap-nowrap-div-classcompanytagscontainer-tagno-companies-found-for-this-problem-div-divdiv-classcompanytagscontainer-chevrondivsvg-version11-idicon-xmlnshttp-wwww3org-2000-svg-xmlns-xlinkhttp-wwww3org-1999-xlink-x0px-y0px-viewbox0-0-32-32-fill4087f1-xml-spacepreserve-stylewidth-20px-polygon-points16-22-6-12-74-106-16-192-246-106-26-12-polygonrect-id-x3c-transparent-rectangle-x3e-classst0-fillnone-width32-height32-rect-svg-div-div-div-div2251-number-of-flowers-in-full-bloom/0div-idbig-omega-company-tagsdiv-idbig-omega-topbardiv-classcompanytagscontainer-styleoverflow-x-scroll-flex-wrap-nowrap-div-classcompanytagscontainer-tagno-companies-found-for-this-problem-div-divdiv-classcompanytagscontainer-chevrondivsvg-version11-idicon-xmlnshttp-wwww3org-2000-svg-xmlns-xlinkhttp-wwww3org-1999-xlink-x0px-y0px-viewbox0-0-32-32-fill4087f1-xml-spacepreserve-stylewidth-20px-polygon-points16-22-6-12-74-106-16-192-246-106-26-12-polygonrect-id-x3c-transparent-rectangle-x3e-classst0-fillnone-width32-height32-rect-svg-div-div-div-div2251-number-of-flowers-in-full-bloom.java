class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        /*int n = people.length;
        int answer[] = new int[n];
        for(int i=0; i<n; i++) {
            int time = people[i];
            int count = 0;
            for(int flower[] : flowers) {
                int st = flower[0];
                int en = flower[1];
                if(time>=st && time<=en) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
        */
        
        int n = people.length;
        int m = flowers.length;
        
        int originalOrderOfPeople[] = new int[n];
        System.arraycopy(people, 0, originalOrderOfPeople, 0, n);
        
        Arrays.sort(people);
        
        Arrays.sort(flowers, (a, b)->a[0]-b[0]);
        
        Map<Integer, Integer> trackPeople = new HashMap<>();
        int j =0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for(int i=0; i<n; i++) {
            int person = people[i];
            while(j<m && flowers[j][0]<=person) {
                heap.offer(flowers[j][1]);
                j++;
            }
            while(!heap.isEmpty() && heap.peek()<person) {
                heap.poll();
            }
            trackPeople.put(person, heap.size());
        }
        
        int answer[] = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = trackPeople.get(originalOrderOfPeople[i]);
        }
        return answer;
    }
}