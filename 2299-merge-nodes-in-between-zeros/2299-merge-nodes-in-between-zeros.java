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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;

        while (curr != null) {
            // If next node is not 0
            if (curr.next.val != 0) {
                // Add next.val to curr.val
                curr.val += curr.next.val;
                // Delete next node
                curr.next = curr.next.next;
            } else {
                // Delete next node, i.e 0
                curr.next = curr.next.next;
                // Change curr ptr to 0's next node
                curr = curr.next;
            }
        }

        return head.next;
    }
}