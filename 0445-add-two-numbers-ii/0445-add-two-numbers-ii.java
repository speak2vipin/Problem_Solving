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
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = null;
        int val = 0;
        int carry = 0;
        while(l1!=null && l2!=null) {
            val = carry;
            
            val += l1.val;
            l1 = l1.next;

            val += l2.val;
            l2 = l2.next;
            
            carry = val/10;
            val = val%10;
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
        }
        while(l1!=null) {
            val = carry;
            val += l1.val;
            l1 = l1.next;
            
            carry = val/10;
            val = val%10;
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;  
        }
        
        while(l2!=null) {
            val = carry;
            val += l2.val;
            l2 = l2.next;
            
            carry = val/10;
            val = val%10;
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr; 
        }
        if(carry!=0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;  
        }
        
        return head;
        
    }
    
    ListNode reverseList(ListNode l1) {
       
        ListNode prev = null;
        ListNode curr = null;
        while(l1!=null) {
            curr = l1;
            l1 = l1.next;
            curr.next = prev;
            prev = curr;
        }
        return curr;
    }
}