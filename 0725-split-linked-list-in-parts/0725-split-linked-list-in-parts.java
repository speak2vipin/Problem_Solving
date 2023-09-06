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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr!=null) {
            count++;
            curr = curr.next;
        }
        ListNode response[] = new ListNode[k];
        curr = head;
        int index = 0;

        if(count<=k) {
            while(curr!=null) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = null;
                response[index++] = temp;
            }
        } else {
            int part = count/k;
            int extra = count%k;
            while(curr!=null) {
                ListNode temp = curr;
                for(int i=0; (i<part-1 && curr!=null); i++) {
                    curr = curr.next; 
                }
                if(curr!=null) {
                    if(extra-->0) {
                        curr = curr.next;
                    }                    
                    ListNode prev = curr;
                    curr = curr.next;
                    prev.next = null;
                }
                response[index++] = temp;
            }
        }
        return response;
    }
}