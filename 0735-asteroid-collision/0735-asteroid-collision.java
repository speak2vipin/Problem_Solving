class Solution {
     public int[] asteroidCollision(int[] asteroids) {
	        Stack<Integer> st = new Stack<>();
	        for(int asteroid : asteroids) {
	            boolean isPush = true;
	            while(!st.isEmpty() && st.peek()>0 && asteroid < 0) {
                    int absolutePeek = Math.abs(st.peek());
                    int absoluteAsteroid = Math.abs(asteroid);
	                if(absolutePeek==absoluteAsteroid) {
	                    isPush = false;
	                    st.pop();
	                    break;
	                } else if(absolutePeek<absoluteAsteroid) {
	                    st.pop();
	                } else {
	                    isPush = false;
	                    break;
	                }
	            }
	            if(isPush)
	            	st.push(asteroid);
	        }
	        int size = st.size();
	        int res[] = new int[size];
	        
	        while(!st.isEmpty()) {
	            res[size-1] = st.pop();
	            size--;
	        }
	        
	        return res;
	    }
}