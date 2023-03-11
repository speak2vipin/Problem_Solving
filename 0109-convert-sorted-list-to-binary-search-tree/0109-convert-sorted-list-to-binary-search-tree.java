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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode prev = null;
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        ListNode temp = getMiddle(head);
        if(temp!=null) {
            root = new TreeNode(temp.val);
            ListNode rightHead = temp.next;
            if(prev!=null) {
                prev.next = null;
                root.left = sortedListToBST(head);
            }
            root.right = sortedListToBST(rightHead);
        }
        return root;
    }

    ListNode getMiddle(ListNode curr) {
        ListNode slow = curr;
        ListNode fast = curr;
        prev = null;
        
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}