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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head==null | head.next==null) {
            return null;
        }
        ListNode prev = head;
        ListNode oneJump = head;
        ListNode doubleJump = head;
        while(doubleJump!=null && doubleJump.next!=null) {
            prev = oneJump;
            oneJump = oneJump.next;
            doubleJump = doubleJump.next.next;
        }
        prev.next = oneJump.next;
        return head;
    
    }
}