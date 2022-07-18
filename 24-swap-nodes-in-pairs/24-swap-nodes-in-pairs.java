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
        if(head==null) {
            return head;
        } 
		ListNode temp = head;
		ListNode prev = null;
		ListNode pred = null;
		int count = 0;
		prev = temp;
		ListNode arb = null;
		temp = temp.next;
		while (temp != null) {
			pred = temp.next;
			temp.next = prev;
			prev.next = pred;

			if (count == 0) {
				head = temp;
				count++;
			}
			if(arb!=null) {
				arb.next = temp;
			}
			arb = prev;
			if (pred != null) {
               prev = pred;
               temp = pred.next;
			}
			else {
				temp = pred;
			}
		}
		return head;

	
    }
}