class Solution {
    double max = 0;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        Map<Integer, ArrayList<Object[]>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], val->new ArrayList<>()).add(
                new Object[]{edges[i][1], succProb[i]});
            adj.computeIfAbsent(edges[i][1], val->new ArrayList<>()).add(
                new Object[]{edges[i][0], succProb[i]});
        }
        
        double[] maxProb = new double[n];
        maxProb[start_node] = 1d;
        
        PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((a,b)-> Double.compare((Double)b[1], (Double)a[1]));
        pq.offer(new Object[]{start_node, 1d});
        while(!pq.isEmpty()) {
            Object[] top = pq.poll();
            Integer target = (Integer)top[0];
            Double val = (Double)top[1];
            if(target==end_node) {
                return val;
            }
            for(Object[] nxt : adj.getOrDefault(target, new ArrayList<>())) {
                Integer nextNode = (Integer)nxt[0];
                Double prob = val * (Double)nxt[1];
                if(maxProb[nextNode]<prob) {
                    maxProb[nextNode] = prob;
                    pq.offer(new Object[]{nextNode, prob});
                }
            }
        }
        return 0d;
    }
    
    void dfs(Map<Integer, ArrayList<Object[]>> adj, 
             boolean visit[], 
             Integer source, 
             Integer target,
            double probability) {
        visit[source] = true;
        if(adj.get(source)!=null) {
            for(Object[] o: adj.get(source)) {
                if((Integer)o[0]==target) {
                    max = Math.max(max, probability*(Double)(o[1]));
                } else if(max<probability && !visit[(Integer)o[0]]) {
                    dfs(adj, visit, (Integer)o[0], target, probability*(Double)(o[1]));
                }
            }
        }
        visit[source] = false;
    }
}