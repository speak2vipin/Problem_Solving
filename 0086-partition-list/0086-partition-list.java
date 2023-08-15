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
    public ListNode partition(ListNode head, int x) {
       
		
		ListNode prev = null;
		ListNode last = null;
		ListNode curr = head;
		ListNode tempPrev = null;
		ListNode tempLast = null;
		boolean isEqual = false;
		boolean isGreater = false;

		while (curr != null) {
			if (curr.val == x) {
				if (!isEqual && !isGreater) {
					prev = tempPrev;
					isEqual = true;
				}
			} else if (curr.val > x) {
				if(!isEqual && !isGreater) {
					last = tempPrev;
					isGreater = true;
				}
			} else {
				if (isGreater) {
					ListNode temp = curr;
					if (tempPrev != null) {
						tempPrev.next = curr.next;
					}
					if (last == null) {
						curr = curr.next;
						temp.next = head;
						head = temp;
						last = temp;
						continue;
					} else {
						temp.next = last.next;
						last.next = temp;
						last = last.next;
					}

				} else if (isEqual) {
					ListNode temp = curr;
					if (tempPrev != null) {
						tempPrev.next = curr.next;
					}
					if (prev == null) {
						curr = curr.next;
						temp.next = head;
						head = temp;
						prev = temp;
						continue;
					} else {
						temp.next = prev.next;
						prev.next = temp;
						prev = prev.next;
					}
				}
			}
			tempLast = tempPrev;
			tempPrev = curr;
			curr = curr.next;

		}
		return head;
	
	
    }
}