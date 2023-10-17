class Solution {
    // Initially find root of the tree by using Set
    // Then use Stack/ Recurssion for DFS
    // If u are going top find a visited node then it will not be a binary tree it would be a graph that is connected by others as well.
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root==-1) {
            return false;
        }
        int visit[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(root);
        visit[root] = 1;
        while(!st.isEmpty()) {
            int last = st.pop();
            int left = leftChild[last];
            int right = rightChild[last];
            if(left!=-1 && visit[left]==1) {
                return false;
            }
            if(right!=-1 && visit[right]==1) {
                return false;
            }
            if(left!=-1) {
                visit[left] = 1;
                st.push(left);
            }
            if(right!=-1) {
                visit[right] = 1;
                st.push(right);
            }
        }
        for(int i=0; i<n; i++) {
            if(visit[i]==0) {
                return false;
            }
        }
        return true;
    }
    
    int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> nodes = new HashSet<>();
        for(int leftNodes : leftChild) {
            nodes.add(leftNodes);
        }
        for(int rightNodes : rightChild) {
            nodes.add(rightNodes);
        }
        for(int i=0; i<n; i++) {
            if(!nodes.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}