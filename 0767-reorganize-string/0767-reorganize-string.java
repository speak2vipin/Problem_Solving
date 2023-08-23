class Solution {
    public String reorganizeString(String s) {
        
		
		PriorityQueue<int[]>pq = new PriorityQueue<>((x,y)->y[0]-x[0]);
        int array[] = new int[26];
        int n = s.length();
        for(int i=0; i<n; i++) {
            array[s.charAt(i)-'a'] = array[s.charAt(i)-'a']+1;
        }
        for(int i=0; i<26; i++) {
        	if(array[i]!=0)
        		pq.offer(new int[] {array[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	int top1[] = pq.poll();
        	if(pq.isEmpty()) {
        		if(top1[0]>1) {
        			return "";
        		} else {
        			sb.append((char)(top1[1]+'a'));
        			break;
        		}	
        	}
        	int top2[] = pq.poll();
        	int x = top1[0];
        	int y = top2[0];
        	sb.append((char)(top1[1]+'a')).append((char)(top2[1]+'a'));
        	
        	if(--x>0) {
        		pq.offer(new int[]{x, top1[1]});
        	}
        	if(--y>0) {
        		pq.offer(new int[]{y, top2[1]});
        	}
        }
        return sb.toString();
         
    
    }
}