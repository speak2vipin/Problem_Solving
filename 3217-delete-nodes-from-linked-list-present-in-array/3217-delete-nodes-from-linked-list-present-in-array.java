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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> numbers = new HashSet<>();
        for(int num : nums) {
            numbers.add(num);
        }
        
        while(head!=null && numbers.contains(head.val)) {
            head = head.next;
        }
        ListNode temp = head;
        while(temp!=null) {
            while(temp.next!=null && numbers.contains(temp.next.val)) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}