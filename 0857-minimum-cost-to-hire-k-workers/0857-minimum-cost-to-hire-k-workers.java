class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double totalCost = Double.MAX_VALUE;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();
        int n = quality.length;
        Integer currentTotalQuality = 0;
        
        // This is needed only to maintain the condition
            // a) Wages have to be in proportion of quality
            // b) Every worker should have minimum defined wage
        // So if we get wage/quality in increasing order then we can met both the conytsraint
        
        for(int i=0; i<n; i++) {
            wageToQualityRatio.add(new Pair<>((double)wage[i]/quality[i], quality[i]));
        }
                                   
        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Pair::getKey));
                                   
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                                   
        for(int i=0; i<n; i++) {
            pq.offer(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();
            if(pq.size()>k) {
                currentTotalQuality -= pq.poll();
            }
            
            if(pq.size()==k) {
                totalCost = 
                    Math.min(totalCost, currentTotalQuality*wageToQualityRatio.get(i).getKey());
            }
        }
        return totalCost;
    }
}