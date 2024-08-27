/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = null;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        preorder(root);
        return res;
    }
    
    void preorder(Node root) {
        if(root==null) {
            return;
        }
        if(root.children!=null) {
            for(Node child : root.children) {
                preorder(child);
            }
        }
        res.add(root.val);
    }
}