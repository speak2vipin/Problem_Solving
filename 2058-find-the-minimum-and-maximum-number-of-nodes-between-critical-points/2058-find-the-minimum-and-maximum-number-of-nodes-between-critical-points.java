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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prev = head.val;
        head = head.next;
        int nextVal = 0;
        int count = 2;
        List<Integer> l = new ArrayList<>();
        while(head.next!=null) {
            nextVal = head.next.val;
            if((head.val>prev && head.val>nextVal) ||(head.val<prev && head.val<nextVal)) {
                l.add(count);
            }
            count++;
            prev = head.val;
            head = head.next;
        }
        
        int min = -1;
        int max = -1;
        if(l.size()>1) {
            min = l.get(1) - l.get(0);
            for(int i=2; i<l.size(); i++) {
                min = Math.min(min, l.get(i) - l.get(i-1));
            }
            max = l.get(l.size()-1) - l.get(0);
        }
        return new int[] {min, max};
        
    }
}