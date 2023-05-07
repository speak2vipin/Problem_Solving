class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        
        int N = queries.length;
        int M = queries[0].length;
        int ans[] = new int[N];
        int colorArray[] = new int[100000];
        ans[0] = 0;
        int tempCount = 0;
        int i = 0;
        for (int[] query : queries) {
            int index = query[0];
            int color = query[1];
            if (colorArray[index] != 0) {
                if (index == 0) {
                    if (colorArray[index] == colorArray[index + 1]) {
                        tempCount--;
                    }
                } else if (index == n - 1) {
                    if (colorArray[index] == colorArray[index - 1]) {
                        tempCount--;
                    }
                } else {
                    if (colorArray[index] == colorArray[index + 1]) {
                        tempCount--;
                    }
                    if (colorArray[index] == colorArray[index - 1]) {
                        tempCount--;
                    }
                }
            }
            // Adding

            if (index == 0) {
                if (color == colorArray[index + 1]) {
                    tempCount++;
                }
            } else if (index == n - 1) {
                if (color == colorArray[index - 1]) {
                    tempCount++;
                }
            } else {
                if (color == colorArray[index + 1]) {
                    tempCount++;
                }
                if (color == colorArray[index - 1]) {
                    tempCount++;
                }
            }
            colorArray[index] = color;
            ans[i++] = tempCount;
        }
        return ans;

    }
}