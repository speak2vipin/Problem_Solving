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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
       
        int count = 1;    
        while(count<a) {
            head = head.next;
            count++;
        }
        ListNode end = head;
        while(count<b+1) {
            end = end.next;
            count++;
        }
        head.next = list2;
        ListNode end2 = list2;
        while(end2.next!=null) {
            end2 = end2.next;
        }
        end2.next = end.next;
        return list1;
        /*HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode head = list1;
        int count = 0;
        while(head!=null) {
            map.put(count++, head);
            head = head.next;
        }
        map.get(a-1).next = list2;
        ListNode end = list2;
        while(end.next!=null) {
            end = end.next;
        }
        end.next = map.get(b).next;
        return list1;*/
    }
}