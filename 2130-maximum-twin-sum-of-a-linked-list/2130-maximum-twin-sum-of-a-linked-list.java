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
        /*Map<Integer, Integer> map = new HashMap<>();
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
    }*/
        
    ListNode slow = head;
    ListNode fast = head;
    // Find mid element
    while(fast!=null && fast.next!=null) {
        //join = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    ListNode dummy = null;
    ListNode curr = null;
        
    // Reversing second half list
    while(slow!=null) {
        curr = slow;
        slow = slow.next;
        curr.next = dummy;
        dummy = curr;
    }
        
    slow = head;
    int max = Integer.MIN_VALUE;
    
    while(curr!=null) {
        max = Math.max(max, slow.val + curr.val);
        slow = slow.next;
        curr = curr.next;
    }
    return max;
    }
}