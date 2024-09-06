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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null) {
            st.push(temp);
            temp = temp.next;
        }
        ListNode last = st.pop();
        int max = last.val;
        
        while(!st.isEmpty()) {
            ListNode curr = st.pop();
            if(curr.val<last.val) {
                continue;
            } else {
                curr.next = last;
                last = curr;
            }
        }
        return last;
    }
}