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
    public void reorderList(ListNode head) {
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
}