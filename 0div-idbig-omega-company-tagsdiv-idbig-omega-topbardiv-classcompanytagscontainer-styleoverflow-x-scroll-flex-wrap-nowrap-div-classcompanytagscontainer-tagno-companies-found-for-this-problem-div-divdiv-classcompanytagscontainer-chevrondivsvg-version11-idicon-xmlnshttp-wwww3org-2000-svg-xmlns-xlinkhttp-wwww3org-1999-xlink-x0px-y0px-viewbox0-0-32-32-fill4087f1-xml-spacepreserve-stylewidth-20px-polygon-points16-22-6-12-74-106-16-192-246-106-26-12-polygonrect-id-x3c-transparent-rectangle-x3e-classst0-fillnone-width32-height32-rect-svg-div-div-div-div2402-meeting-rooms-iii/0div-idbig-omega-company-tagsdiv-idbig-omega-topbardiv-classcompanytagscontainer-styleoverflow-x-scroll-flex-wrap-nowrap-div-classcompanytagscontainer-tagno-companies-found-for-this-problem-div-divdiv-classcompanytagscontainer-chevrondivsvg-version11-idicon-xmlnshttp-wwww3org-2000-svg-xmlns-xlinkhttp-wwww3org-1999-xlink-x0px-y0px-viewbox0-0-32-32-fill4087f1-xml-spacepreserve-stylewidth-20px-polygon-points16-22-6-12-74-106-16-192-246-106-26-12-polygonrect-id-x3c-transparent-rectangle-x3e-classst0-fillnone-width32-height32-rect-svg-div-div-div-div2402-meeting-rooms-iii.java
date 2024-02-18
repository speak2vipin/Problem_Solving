class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // PriorityQueue<long[]> used = 
          //   new PriorityQueue<long[]>((a, b) -> a[1] != b[1] ? //Long.compare(a[1], b[1]) : Long.compare(a[2], b[2]));
        PriorityQueue<long[]> used = new PriorityQueue<long[]>(
          (x,y)->x[1]==y[1] ? (int)(x[2]-y[2]) : (int)(x[1]-y[1]));
      PriorityQueue<Integer> unused = new PriorityQueue<Integer>();
      
      Arrays.sort(meetings, (x,y)->x[0]==y[0] ? x[1]-y[1] : x[0]-y[0]);
//Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : //Integer.compare(a[1], b[1]));
      
        for(int i=0; i<n; i++) {
          unused.offer(i);
      }
      
      int meetingsCount[] = new int[n];
      
      for(int i=0; i<meetings.length; i++) {
          int st = meetings[i][0];
          int en = meetings[i][1];
          
          while(!used.isEmpty() && used.peek()[1]<=st) {
              unused.offer((int)used.poll()[2]);
          }
          
          if(!unused.isEmpty()) {
              int available = unused.poll();
              meetingsCount[available]++;
              used.offer(new long[]{st, en, available});
          } else {
              long top[] = used.poll();
              meetingsCount[(int)top[2]]++;
              used.offer(new long[]{top[1], top[1] + (en-st),  top[2]});
          }   
      }
      
      int temp = Integer.MIN_VALUE;
      int ans = Integer.MAX_VALUE;
      for(int i=0; i<n; i++) {
          if(temp<meetingsCount[i]) {
              ans = i;
              temp = meetingsCount[i];
          }
      }
      return ans;   
        
    }
}