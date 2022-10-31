class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
		int M = matrix[0].length;
		int N = matrix.length;

		for (int y = M - 1; y > -1; y--) {
			int i = 0;
			int j = y;
			while (j + 1 < M && i + 1 < N) {
				if (matrix[i][j] == matrix[i + 1][j + 1]) {
					i++;
					j++;
					continue;
				} else {
					return false;
				}
			}
		}
		for (int x = N - 1; x > 0; x--) {
			int i = x;
			int j = 0;
			while (j + 1 < M && i + 1 < N) {
				if (matrix[i][j] == matrix[i + 1][j + 1]) {
					i++;
					j++;
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
    }
}