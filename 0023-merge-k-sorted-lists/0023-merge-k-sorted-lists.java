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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;

        for(int i = 1; i < lists.length;i++){
            lists[0] = mergelist(lists[0], lists[i]);
        }
        return lists[0];
    }
    public ListNode mergelist(ListNode n1, ListNode n2){
        ListNode d = new ListNode(-1);
        ListNode prev = d;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                prev.next = n1;
                n1 = n1.next;
            }
            else{
                prev.next = n2;
                n2=n2.next;
            }
            prev = prev.next;
        }
        prev.next = (n1 == null) ? n2 : n1;
        return d.next;
    }
}