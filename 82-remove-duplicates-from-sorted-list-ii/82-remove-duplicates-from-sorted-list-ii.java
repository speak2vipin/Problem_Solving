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
    public ListNode deleteDuplicates(ListNode head) {
        
		List<Integer> nodeVal = new ArrayList<Integer>();
		List<Integer> duplicateVal = new ArrayList<Integer>();
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null) {
			if (!nodeVal.contains(temp.val)) {
				nodeVal.add(temp.val);
			} else {
				duplicateVal.add(temp.val);
			}
			temp = temp.next;
		}
		temp = head;
		while (temp!=null) {
			if (!duplicateVal.contains(temp.val)) {
				if (prev == null) {
					prev = temp;
				} else {
					prev.next = temp;
					prev = temp;
				}
				temp = temp.next;
			} else {
				// Need to take care when duplicates is at starting
				if(prev==null) {
					head = head.next;
				}
				temp = temp.next;
			}
		}
		// Need to take care if duplicates is at corners
		if(prev!=null)
			prev.next = null;
		return head;

	
    }
}