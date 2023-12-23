class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        //Set<Dim> dimSet = new HashSet<>();
        Set<Pair<Integer, Integer>> dimSet = new HashSet<>();
        int point[] = {0,0};
        dimSet.add(new Pair(point[0], point[1]));
        for(int i=0; i<n; i++) {
            char c = path.charAt(i);
            if(c=='N') {
                point[1]++;
            } else if(c=='E') {
                point[0]++;
            } else if(c=='S') {
                point[1]--;
            } else {
                point[0]--;
            }
            Pair<Integer, Integer> pair = new Pair(point[0], point[1]);
            if(dimSet.contains(pair)) {
                return true;
            }
            dimSet.add(pair);
        }
        
        return false;
    }
}

class Dim {
    int x;
    int y;
    public Dim(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
    	return x+y;
    }
    @Override
	public boolean equals(Object o) {
    	Dim dim = (Dim)o;
    	return x==dim.x && y==dim.y;
    }
}