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
    ListNode temp = null;
    int total = 0;
    public Solution(ListNode head) {
        temp = head;
        while(temp!=null) {
            total++;
            temp = temp.next;
        }
        temp = head;
    }
    
    public int getRandom() {
        Random r = new Random();
        int num = r.nextInt(total);
        ListNode curr = temp;
        while(num>0 && curr.next!=null) {
            curr = curr.next;
            num--;
        }
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */