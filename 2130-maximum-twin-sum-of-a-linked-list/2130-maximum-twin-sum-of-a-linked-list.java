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
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        //int total = 0;
        ListNode curr = head;
        int index = 1;
        while(curr!=null) {
            int val = curr.val;
            curr = curr.next;
            map.put(index++, val);
        }
        index--;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=index/2; i++) {
            max = Math.max(max, map.get(i) + map.get(index+1-i));
        }
        return max;
    }
}