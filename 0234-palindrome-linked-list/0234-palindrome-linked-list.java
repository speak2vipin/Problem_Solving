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
    public boolean isPalindrome(ListNode A) { 
        if(A.next==null) {
            return true;
        }
        // Simple approach
        // Find middle of Linkedlist in parallel reverse the linkedlist
        // Find no of nodes
        // If no of node are odd then slow = slow.next or if it even then just compare slow         // and prev i.e. reversed list
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = null;
        ListNode temp = null;
        int count = 1;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
            temp = slow;
            count = count + 2 ;
        }
        if(fast==null) {
            count--;
        }
        if(count%2 != 0) {
            slow = slow.next;
        } 
        while(slow!=null) {
            if(slow.val == prev.val) {
                slow = slow.next;
                prev = prev.next;
            } else {
                return false;
            }
        }
        return true;
    }
}