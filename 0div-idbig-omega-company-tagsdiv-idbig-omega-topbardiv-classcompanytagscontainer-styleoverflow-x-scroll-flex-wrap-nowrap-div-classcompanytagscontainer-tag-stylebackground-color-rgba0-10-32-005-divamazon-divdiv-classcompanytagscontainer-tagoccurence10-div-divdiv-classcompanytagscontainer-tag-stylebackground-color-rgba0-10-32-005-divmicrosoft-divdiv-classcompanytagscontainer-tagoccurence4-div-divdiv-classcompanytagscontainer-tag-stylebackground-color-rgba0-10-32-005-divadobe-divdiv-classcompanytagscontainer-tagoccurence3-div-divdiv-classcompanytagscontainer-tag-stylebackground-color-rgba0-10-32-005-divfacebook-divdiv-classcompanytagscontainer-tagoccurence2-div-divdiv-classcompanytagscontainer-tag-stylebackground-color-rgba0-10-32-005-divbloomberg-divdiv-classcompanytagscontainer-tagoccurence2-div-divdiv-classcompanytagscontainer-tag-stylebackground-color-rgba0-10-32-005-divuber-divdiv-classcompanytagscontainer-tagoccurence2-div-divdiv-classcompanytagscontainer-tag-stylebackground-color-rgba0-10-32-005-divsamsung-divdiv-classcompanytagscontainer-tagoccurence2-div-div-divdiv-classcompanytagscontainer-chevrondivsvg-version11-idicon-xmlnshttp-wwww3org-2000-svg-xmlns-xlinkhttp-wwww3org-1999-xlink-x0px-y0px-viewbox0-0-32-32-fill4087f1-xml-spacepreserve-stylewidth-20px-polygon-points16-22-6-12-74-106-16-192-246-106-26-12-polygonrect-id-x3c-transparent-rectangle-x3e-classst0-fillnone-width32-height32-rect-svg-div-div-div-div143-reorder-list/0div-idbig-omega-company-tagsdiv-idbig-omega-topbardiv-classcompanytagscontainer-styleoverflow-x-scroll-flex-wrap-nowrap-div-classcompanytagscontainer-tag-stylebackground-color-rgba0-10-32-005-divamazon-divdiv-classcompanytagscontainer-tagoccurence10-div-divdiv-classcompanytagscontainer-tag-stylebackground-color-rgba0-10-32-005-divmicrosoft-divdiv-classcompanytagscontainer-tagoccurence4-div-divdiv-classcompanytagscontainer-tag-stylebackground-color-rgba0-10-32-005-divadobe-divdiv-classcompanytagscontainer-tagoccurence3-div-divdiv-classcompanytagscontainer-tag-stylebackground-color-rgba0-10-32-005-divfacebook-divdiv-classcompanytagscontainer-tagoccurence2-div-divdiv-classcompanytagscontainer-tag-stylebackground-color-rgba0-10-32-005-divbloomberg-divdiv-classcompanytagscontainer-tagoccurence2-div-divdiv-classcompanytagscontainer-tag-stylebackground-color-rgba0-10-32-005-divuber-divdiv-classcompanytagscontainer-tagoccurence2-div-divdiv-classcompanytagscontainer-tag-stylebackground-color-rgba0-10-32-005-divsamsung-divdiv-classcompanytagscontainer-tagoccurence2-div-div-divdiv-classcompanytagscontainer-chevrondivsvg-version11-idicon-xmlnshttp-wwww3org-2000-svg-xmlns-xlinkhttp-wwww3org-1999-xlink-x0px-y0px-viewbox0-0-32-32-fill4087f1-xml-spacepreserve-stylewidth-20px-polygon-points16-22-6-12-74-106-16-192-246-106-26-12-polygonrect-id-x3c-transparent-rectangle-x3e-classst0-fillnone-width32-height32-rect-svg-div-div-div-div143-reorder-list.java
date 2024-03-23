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
    public void reorderListByHashMap(ListNode head) {
        ListNode temp = head;
        List<ListNode> l = new ArrayList<ListNode>();
        while(temp!=null) {
            l.add(temp);
            temp = temp.next;
        }
        int i=0;
        int j=l.size()-1;
        
        while(i<=j) {
            l.get(i).next = l.get(j);
            if(temp!=null) {
                temp.next = l.get(i);
            }
            temp = l.get(i).next;
            i++;
            j--;
        }
        temp.next = null;
        l.clear();
    }
    
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast!=null) {
            //ListNode common = slow;
            slow = slow.next;
            //common.next = null;
        }
        ListNode prev = null;
        ListNode temp = null;
        while(slow!=null) {
            temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        temp = head;
        ListNode head1 = null;
        ListNode head2 = null;
        while(prev!=null && temp!=null) {
            head1 = temp;
            temp = temp.next;
            head2 = prev;
            prev = prev.next;
            head1.next = head2;
            head2.next = temp;
        }
        temp.next = null;
        
    }
}