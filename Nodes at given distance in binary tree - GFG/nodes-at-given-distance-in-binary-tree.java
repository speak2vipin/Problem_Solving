//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		HashSet<Integer> visited = new HashSet<>();
		Queue<int[]> qe = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		formGraph(graph, root, null);
		if (graph.get(target) != null) {
			qe.offer(new int[] { target, 0 });
			visited.add(target);
			while (!qe.isEmpty()) {
				int[] top = qe.poll();
				int element = top[0];
				int distance = top[1];
				if (distance == k) {
					ans.add(element);
					continue;
				}
				if (graph.get(element) != null) {
					for (Integer neighbor : graph.get(element)) {
						if (!visited.contains(neighbor)) {
							qe.offer(new int[] { neighbor, distance + 1 });
							visited.add(neighbor);
						}
					}
				}
			}
		}
		Collections.sort(ans);
		return ans;
	}

	static void formGraph(HashMap<Integer, ArrayList<Integer>> graph, Node node, Node parent) {
		if (node != null && parent != null) {
			ArrayList<Integer> nodeL = graph.getOrDefault(node.data, new ArrayList<Integer>());
			nodeL.add(parent.data);
			graph.put(node.data, nodeL);
			ArrayList<Integer> nodeP = graph.getOrDefault(parent.data, new ArrayList<Integer>());
			nodeP.add(node.data);
			graph.put(parent.data, nodeP);
		}
		if (node != null && node.left != null) {
			formGraph(graph, node.left, node);
		}
		if (node != null && node.right != null) {
			formGraph(graph, node.right, node);
		}
	}

    
    
};