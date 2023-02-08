class Solution {
    public int jump(int[] nums) {
 
        PriorityQueue<Temp>pq = new PriorityQueue<Temp>(new Comparator<Temp>() {
			@Override
			public int compare(Temp o1, Temp o2) {
				// TODO Auto-generated method stub
				return o2.reach==o1.reach ? (o2.index-o1.index) : o2.reach-o1.reach;
			}
		});
        int i = 0;
        int jump = 1;
        int N = nums.length;
        if(N==1) {
			return 0;
		}
        while(i+nums[i]<N-1) {
            for(int j=i+1; j<=i+nums[i] && j<N-1; j++) {
            	pq.offer(new Temp(j,j+nums[j]));
            }
            Temp top = pq.poll();
            i = top.index;
            jump++;
            pq.clear();
        }
        return jump; 
    
    }
}
class Temp {
    int index;
    int reach;
    public Temp(int index, int reach) {
        this.index = index;
        this.reach = reach;
    }
}