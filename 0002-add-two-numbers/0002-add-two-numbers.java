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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int carry = 0;
        int val = 0;
        while(l1!=null && l2!=null) {
            val = l1.val+l2.val+carry;
            carry = val/10;
            val = val%10;
            if(temp==null) {
                temp = new ListNode(val);
                head = temp;
            } else {
                temp.next = new ListNode(val);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null) {
            val = l1.val+carry;
            carry = val/10;
            val = val%10;
            temp.next = new ListNode(val);
            temp = temp.next;
            l1 = l1.next;
        }
         while(l2!=null) {
            val = l2.val+carry;
            carry = val/10;
            val = val%10;
            temp.next = new ListNode(val);
            temp = temp.next;
            l2 = l2.next;
        }
        while(carry!=0) {
            val = carry;
            carry = val/10;
            val = val%10;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head;
    }
}