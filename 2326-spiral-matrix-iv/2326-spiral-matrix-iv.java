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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int res[][] = new int[m][n];
        for(int r[] : res) {
            Arrays.fill(r, -1);
        }
        
        int i=0, j=0, curr_d=0;
        int movement[][] = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}};
        while(head!=null) {
            res[i][j] = head.val;
            int newi = i + movement[curr_d][0];
            int newj = j + movement[curr_d][1];
            if(newi<0 || newj<0 || newi>m-1 || newj>n-1 || res[newi][newj]!=-1) {
                curr_d = (curr_d+1)%4;
            }
            i = i + movement[curr_d][0];
            j = j + movement[curr_d][1];
            head = head.next;
        }
        return res;
    }
}