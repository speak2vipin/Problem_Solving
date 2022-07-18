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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp= head;
        int tempVal = 0; 
        ListNode newHead = null;
        ListNode tempHead = null;
        while(head!=null) {
            if(head.val==0 && tempVal!=0) {
                if(newHead==null) {
                    tempHead = new ListNode(tempVal);
                    newHead = tempHead; 
                    
                } else {
                    tempHead.next = new ListNode(tempVal);
                    tempHead = tempHead.next;
                }
                tempVal = 0;
            } else {
                tempVal+=head.val;
            }
            head = head.next;
        }
        return newHead;
    }
}