/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       /* Map<Node, Node> map = new HashMap<>();
        Node res = null;
        Node curr = null;
        int index = 0;
        Node originalHead = head;
        while(originalHead!=null) {
            Node temp = new Node(originalHead.val);
            if(res == null) {
                curr = temp;
                res = curr;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
            map.put(originalHead, temp);
            originalHead = originalHead.next;
        }
        
        originalHead = head;
        curr = res;
        
        while(originalHead!=null) {
            curr.random = map.get(originalHead.random);
            curr = curr.next;
            originalHead = originalHead.next;
        }
        return res;
        */
        
        return copyRandomListWithoutSpaceComplexity(head);
    }
    
     public Node copyRandomListWithoutSpaceComplexity(Node head) {
        if(head==null) {
            return null;
        }
        Node originalHead = head;
         
        while(originalHead!=null) {
            
            Node temp = new Node(originalHead.val);
        	Node prev = originalHead;
            originalHead = originalHead.next;
            prev.next = temp;
            temp.next = originalHead;
        }
         
        originalHead = head;
        while(originalHead!=null) {
            if(originalHead.random!=null) {
                originalHead.next.random = originalHead.random.next;
            }
            originalHead = originalHead.next.next;
        }
         
        originalHead = head;
        Node res = originalHead.next;
        while(originalHead!=null && originalHead.next!=null) {
        	Node temp = originalHead.next;
            originalHead.next = originalHead.next.next;
            if(temp.next!=null) { 
            	temp.next = temp.next.next;
            }
            originalHead = originalHead.next; 
        }
        return res;
     }        
}