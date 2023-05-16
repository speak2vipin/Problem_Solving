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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        boolean isHeadSet = true;
        ListNode join = null;
        while(curr!=null && curr.next!=null) {
            prev = curr;
            curr = curr.next.next;
            ListNode temp = prev.next;
            prev.next = temp.next;
            temp.next = prev;
            if(isHeadSet) {
                head = temp;
                isHeadSet = false;
                join = prev;
            } else {
                join.next = temp;
                join = prev;
            }
        }
        return head;
        
    }
}