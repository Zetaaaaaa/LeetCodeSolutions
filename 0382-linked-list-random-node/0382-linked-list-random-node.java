class Solution {
    ListNode temp;

    public Solution(ListNode head) {
        this.temp = head;
    }

    public int getRandom() {
        int ans = temp.val;
        ListNode ptr = temp.next;
        int i = 2;

        while (ptr != null) {
            if ((Math.random() * i++) < 1)
                ans = ptr.val;
                
            ptr = ptr.next;
        }

        return ans;
    }
}