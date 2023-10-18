class Solution {
    public int scheduleCourse(int[][] courses) {
        // Create a Max Heap
        // Sort courses in ascending order by its finish time
        // Check total time taken with the deadline
            // If it's greater, remove the highest durationsed course
            // Or else add it in max heap
        // Heap will contain all the courses which would be feasible with the given deadline
        // Size of heap will tell the feasible courses so resturn maxHeap.size()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int total = 0;
        Arrays.sort(courses, (x,y)->x[1]-y[1]);
        for(int[] course : courses) {
            maxHeap.add(course[0]);
            if((total+=course[0])>course[1]) {
                total -= maxHeap.poll(); 
            }
        }
        return maxHeap.size();
    }
}