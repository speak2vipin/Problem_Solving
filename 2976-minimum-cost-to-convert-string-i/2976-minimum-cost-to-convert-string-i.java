import java.util.*;

class Solution {
    
    Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
    int n = 0;
    
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        // Build the adjacency list representation of the graph
        n = original.length;
        for(int i=0; i<n; i++) {
            adj.computeIfAbsent(original[i] - 'a', val -> new ArrayList<>())
               .add(new int[]{changed[i] - 'a', cost[i]});
        }
        
        // To store the minimum cost of conversion from every character to every other character
        long[][] minDistanceOfEveryChar = new long[26][26];
        
        // Initialize the distances with a large value (or -1 if unreachable)
        for (int i = 0; i < 26; i++) {
            Arrays.fill(minDistanceOfEveryChar[i], Long.MAX_VALUE);
            minDistanceOfEveryChar[i][i] = 0; // Distance from a character to itself is zero
        }
        
        // Calculate the minimum cost to convert each character to every other character
        for (int i = 0; i < 26; i++) {
            minDistanceOfEveryChar[i] = dijkstra(i);
        }
        
        long totalCost = 0;
        int sourceLen = source.length();
        
        // Calculate the total conversion cost from the source string to the target string
        for (int i = 0; i < sourceLen; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long conversionCost = minDistanceOfEveryChar[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (conversionCost == Long.MAX_VALUE) {
                    return -1; // Return -1 if the conversion is not possible
                }
                totalCost += conversionCost;
            }
        }
        
        return totalCost;
    }
    
    long[] dijkstra(int st) {
        
        // Priority queue to store (cost, character)
        PriorityQueue<long[]> pq = new PriorityQueue<>((x,y)->Long.compare(x[0], y[0]));
        
        pq.offer(new long[]{0L, st});
        
        long[] distance = new long[26];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[st] = 0;
        
        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long cost = top[0];
            int currentChar = (int) top[1];
            
            // If the current cost is greater than the recorded distance, continue
            if (cost > distance[currentChar]) {
                continue;
            }
            
            // Traverse all neighbors
            for (int[] neighbors : adj.getOrDefault(currentChar, new ArrayList<>())) {
                int targetChar = neighbors[0];
                int targetCost = neighbors[1];
                long newTotalCost = cost + targetCost;
                
                if (newTotalCost < distance[targetChar]) {
                    distance[targetChar] = newTotalCost;
                    pq.offer(new long[]{newTotalCost, targetChar});
                }
            }
        }
        
        return distance;
    }      
}
