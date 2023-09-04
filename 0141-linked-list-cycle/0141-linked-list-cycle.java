/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean isCycle = false;
        if(head==null) {
            return isCycle;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null) {
            if(slow==fast) {
                isCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return isCycle;
    }
}