class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
		int matrix[][] = new int[n][3];
		for (int i = 0; i < n; i++) {
			int dir = directions.charAt(i) == 'R' ? 1 : -1;
			matrix[i] = new int[] { positions[i], healths[i], dir, i };
		}

		Arrays.sort(matrix, (x, y) -> Integer.compare(x[0], y[0]));

		Stack<int[]> st = new Stack<>();
		for (int i = 0; i < n; i++) {
            //L,R
            //R,L
            //L,L
          //  R,R
            boolean processed = true;
			while (!st.isEmpty() && st.peek()[2] != matrix[i][2] && st.peek()[2]==1) {
				int top[] = st.pop();
				if (top[1] > matrix[i][1]) {
					top[1] --;
					st.push(top);
                    processed = false;
                    break;
				} else if (top[1] < matrix[i][1]) {
					matrix[i][1] --;
				} else {
                    processed = false;
                    break;
                }
			} 
            if(processed) {
				st.push(matrix[i]);
			}
		}
		List<Integer> ans = new ArrayList<>();
		if (st.isEmpty()) {
			return ans;
		}
		List<int[]> li = new ArrayList<>(st);
		Collections.sort(li, (x, y) -> Integer.compare(x[3], y[3]));

		for (int element[] : li) {
			ans.add(element[1]);
		}
		return ans;

    }
}