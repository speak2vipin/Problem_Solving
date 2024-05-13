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
        
        int c = 0;
        ListNode temp = head;
        while(temp!=null) {
            c++;
            temp=temp.next;
        }
        if(c-n==0) {
            return head.next;
        } else {
            temp = head;
            while(c-n>1) {
                temp = temp.next;
                c--;
            }
            temp.next = temp.next.next;
            return head;
        }
    }
}