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
        // Copy original array to a new array so that we won't miss the order of people post sorting
        int originalOrderOfPeople[] = new int[n];
        System.arraycopy(people, 0, originalOrderOfPeople, 0, n);
        // Sort people by there arrival time in increasing order
        Arrays.sort(people);
        // Sort flowers by there starting time in increasing order
        Arrays.sort(flowers, (a, b)->a[0]-b[0]);
        
        Map<Integer, Integer> trackPeople = new HashMap<>();
        int j =0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for(int i=0; i<n; i++) {
            int person = people[i];
            // Add all the elements who's starting time is equal or lesser than arrival time of people[i]
            while(j<m && flowers[j][0]<=person) {
                heap.offer(flowers[j][1]);
                j++;
            }
            // Remove all the elements who's end time is less than arrival time of people[i]
            
            while(!heap.isEmpty() && heap.peek()<person) {
                heap.poll();
            }
            // place the heap size wrt arrival time
            trackPeople.put(person, heap.size());
        }
        
        int answer[] = new int[n];
        for(int i=0; i<n; i++) {
            // Fetch value by arrival time ans place it to answer array
            answer[i] = trackPeople.get(originalOrderOfPeople[i]);
        }
        return answer;
    }
}