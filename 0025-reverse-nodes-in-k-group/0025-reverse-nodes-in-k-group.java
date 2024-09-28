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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null)   return head;
        ListNode temp = head;
        int size=1;
        ListNode dummy = new ListNode(0);
        ListNode t= dummy;
        ListNode Next = null;
        while(temp != null){
            if(size==k){
                Next = temp.next;
                temp.next = null;
                ListNode newhead = reverse(head);
                t.next=newhead;
                t=head;
                head = Next;
                temp = Next;
                size = 1;
            }
            else{
                size++;
                temp=temp.next;
            }
            if(Next != null){
                t.next = Next;
            }
        }
            return dummy.next;

        
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;
        while(curr != null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}