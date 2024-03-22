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
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        ListNode prev = null;
        
        int half = (count)/2;
        while(half-->0) {
            temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        if((count%2)!=0) {
            head = head.next;
        }
        while(head!=null && temp!=null && head.val==temp.val) {
            head = head.next;
            temp = temp.next;
        }
        return head==null && temp==null;
    }
}