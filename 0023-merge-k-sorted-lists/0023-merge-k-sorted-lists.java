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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        
        PriorityQueue<ListNode>pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0; i<k; i++) {
            if(lists[i]!=null)
                pq.offer(lists[i]);
        }
        ListNode head = null;
        ListNode curr = null;
        ListNode temp = null;
        while(!pq.isEmpty()) {
            temp = pq.poll();
            if(temp.next!=null)
                pq.offer(temp.next);
            if(head==null) { 
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }
}