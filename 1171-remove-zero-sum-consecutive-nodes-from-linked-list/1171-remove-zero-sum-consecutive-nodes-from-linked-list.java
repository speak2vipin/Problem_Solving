/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublistsTraverse(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode start = front;
        while(start!=null) {
            int prefix = 0;
            ListNode end = start.next;
            while(end!=null) {
                prefix += end.val;
                if(prefix == 0 ){
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return front.next;
        
    }
    
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        prefixSumToNode.put(0, front);
         while(current!=null) {
            prefixSum += current.val;
            prefixSumToNode.put(prefixSum, current);
             current = current.next;
        }
        prefixSum = 0;
        current = front;
        while(current!=null) {
            prefixSum += current.val;
            current.next = prefixSumToNode.get(prefixSum).next;
            
             current = current.next;
        }
        return front.next;
        
    }
}