class Solution {
    public int scheduleCourse(int[][] courses) {
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