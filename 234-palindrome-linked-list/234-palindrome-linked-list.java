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
        
        ListNode reverseHead = null;
        ListNode tempHead = head;
        ListNode prev = null;
        
        while(tempHead!=null) {
            reverseHead = new ListNode(tempHead.val);
            tempHead = tempHead.next;
            reverseHead.next = prev;
            prev = reverseHead;
        }
        while(head!=null && reverseHead!=null) {
            if(head.val==reverseHead.val) {
            	 head = head.next;
                 reverseHead = reverseHead.next;
                continue;
            } else {
                return false;
            }
        
        }
        
        return true;
        
    
        
    }
}