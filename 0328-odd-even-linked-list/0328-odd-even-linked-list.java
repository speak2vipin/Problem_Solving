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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode tempOdd = odd;
        ListNode tempEven = even;
        ListNode prev = null;
        while(tempOdd!=null) {
            if(tempEven!=null) {
                tempOdd.next = tempEven.next;
                prev = tempOdd;
                tempOdd = tempEven.next;
            } else {
                prev = tempOdd;
                tempOdd.next = null;
                break;
            }
            if(tempOdd!=null) {
                tempEven.next = tempOdd.next;
                tempEven = tempOdd.next;
            } else {
                tempEven.next = null;
                break;
            }   
        }
        prev.next = even;
        head = odd;
        return head;
    }
}