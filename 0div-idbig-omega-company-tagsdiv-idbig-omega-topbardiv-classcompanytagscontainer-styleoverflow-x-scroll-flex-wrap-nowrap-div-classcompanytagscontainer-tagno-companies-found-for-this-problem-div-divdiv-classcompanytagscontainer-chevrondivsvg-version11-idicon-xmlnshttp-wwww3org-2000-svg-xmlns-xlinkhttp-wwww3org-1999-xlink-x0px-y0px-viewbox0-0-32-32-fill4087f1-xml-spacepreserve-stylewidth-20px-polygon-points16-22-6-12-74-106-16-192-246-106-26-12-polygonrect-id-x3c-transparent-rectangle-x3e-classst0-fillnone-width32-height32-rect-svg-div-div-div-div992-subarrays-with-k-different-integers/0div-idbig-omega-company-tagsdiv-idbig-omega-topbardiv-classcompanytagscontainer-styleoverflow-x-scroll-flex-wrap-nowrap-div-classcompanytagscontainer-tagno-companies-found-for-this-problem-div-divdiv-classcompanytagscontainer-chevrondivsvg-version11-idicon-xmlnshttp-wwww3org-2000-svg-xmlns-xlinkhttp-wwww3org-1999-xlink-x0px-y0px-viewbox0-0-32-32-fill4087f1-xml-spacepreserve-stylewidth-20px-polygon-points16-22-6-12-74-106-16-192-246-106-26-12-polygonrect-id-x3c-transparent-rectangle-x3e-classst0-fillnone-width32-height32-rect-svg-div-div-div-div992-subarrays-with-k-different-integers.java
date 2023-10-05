class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            //window1.add(x);
            //window2.add(x);
            map1.put(x, map1.getOrDefault(x, 0)+1);
            map2.put(x, map2.getOrDefault(x, 0)+1);

            while (map1.size() > K) {
                map1.put(A[left1], map1.get(A[left1])-1);
                if(map1.get(A[left1])==0) {
                    map1.remove(A[left1]);
                }
                left1++;
            }
            while (map2.size() >= K) {
                map2.put(A[left2], map2.get(A[left2])-1);
                if(map2.get(A[left2])==0) {
                    map2.remove(A[left2]);
                }
                left2++;
            }

            ans += left2 - left1;
        }

        return ans;
    }
}

class Window {
    Map<Integer, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }
}