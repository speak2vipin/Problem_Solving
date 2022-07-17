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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
		ListNode temp = head;
		ListNode prev = null;
		ListNode leftI = null;
		ListNode rightI = null;
		ListNode fake = null;
		if (left == right) {
			return head;
		}
		int count = 0;
		while (temp != null && count < left) {
			leftI = prev;
			prev = temp;
			rightI = prev;
			temp = temp.next;
          //  head = head.next;
			count++;
		}
        
		while (temp != null && count < right) {
			fake = prev;
			prev = temp;
			temp = temp.next;
			prev.next = fake;
			count++;
		}
		if(leftI!=null)
			leftI.next = prev;
		//if(temp!=null) {
			rightI.next = temp;
        //} else {
            
        //}
        if(left==1) {
            head = prev;
        }
		return head;
    }
}