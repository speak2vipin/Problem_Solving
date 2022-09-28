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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNode = 0;
        ListNode temp = head;
        while(temp!=null) {
            totalNode++;
            temp = temp.next;
        }
        if(n>totalNode) {
            return head;
        }
        // Take care of traversing
        int travel = totalNode-n-1;
        
        if(travel<0) {
            head = head.next;
        } else {
            temp = head;
            while(travel>0) {
                temp = temp.next;
                travel--;
            }
            // It will cover general scenario as well as scenario where node is in the last
            temp.next = temp.next.next;
        }
        return head;
    }
}