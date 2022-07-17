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
    public int numComponents(ListNode head, int[] nums) {	
		ListNode temp = head;
		int count = 0;
        List<Integer> inputL = new ArrayList<Integer>();
		List<Integer> numberL = new ArrayList<Integer>();
        while(temp!=null) {
        	numberL.add(temp.val);  
        	temp = temp.next;
        }
		
		for (int i = 0; i < nums.length; i++) {
			inputL.add(nums[i]);
		}
		boolean flag = false;
		for (int j = 0; j < numberL.size(); j++) {
			if (flag && inputL.contains(numberL.get(j))) {
				continue;
			} else if (flag && !inputL.contains(numberL.get(j))) {
				flag = false;
				count++;
			} else if (inputL.contains(numberL.get(j))) {
				flag = true;
			}
		}
		if(flag) {
			count++;
		}
		return count;

	
    }
}