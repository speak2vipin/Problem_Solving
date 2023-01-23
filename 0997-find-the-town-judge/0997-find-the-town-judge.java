class Solution {
    public int findJudge(int n, int[][] trust) {
        int ans = -1;
        if(trust.length==0) {
            if(n==1) {
                ans=1;
            }
        } else {
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            ArrayList<Integer> people = new ArrayList<Integer>();
            for(int[] t : trust) {
                map.put(t[1], map.getOrDefault(t[1],0)+1);
                people.add(t[0]);
            }

            for(int[] t : trust) {
                if(!people.contains(t[1]) && map.get(t[1])==n-1) {
                    ans = t[1];
                    break;
                }
            }
        }
        return ans;
    }
}