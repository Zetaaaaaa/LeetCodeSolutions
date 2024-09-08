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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = countNodes(head);
        int parts = n / k, r = n % k;
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            res[i] = curr;
            int partSize = parts + (r > 0 ? 1 : 0);
            for (int j = 1; j < partSize; j++)
                curr = curr.next;
            ListNode nextPart = curr.next;
            curr.next = null;
            curr = nextPart;
            r--;
        }
        return res;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}