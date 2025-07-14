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
    public int getDecimalValue(ListNode head) {
        int num = 0;
        int len = 0;

        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            len--;
            if (tmp.val == 1) {
                num += (1 << len);
            }
            tmp = tmp.next;
        }

        return num;
    }
}