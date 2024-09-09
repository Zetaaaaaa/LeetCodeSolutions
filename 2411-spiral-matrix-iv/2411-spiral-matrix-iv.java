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
        ListNode temp = head;
        int top_row = 0;
        int bottom_row = m-1;
        int first_col = 0;
        int last_col = n-1;
        int num=1;
        int[][] arr = new int[m][n];
        while(top_row<=bottom_row && first_col<=last_col){
        for(int i=first_col;i<=last_col;i++){
            if(temp == null)
            arr[top_row][i] = -1;
            else{
            arr[top_row][i] = temp.val;
            temp=temp.next;
            }
        }
        for(int i=top_row+1;i<=bottom_row;i++){
            if(temp == null)
            arr[i][last_col] = -1;
            else{
            arr[i][last_col] = temp.val;
             temp=temp.next;
            }
        }
        if(top_row == bottom_row  || first_col == last_col)
        break;
        for(int i=last_col-1;i>=first_col;i--){
            if(temp == null){
                arr[bottom_row][i] = -1;
            }
            else{
            arr[bottom_row][i] = temp.val;
             temp=temp.next;
        }
        }
        for(int i=bottom_row-1;i>=top_row+1;i--){
            if(temp == null){
                arr[i][first_col]  = -1;
            }
            else{
            arr[i][first_col] = temp.val;
            temp=temp.next;
        }
        }
        if(top_row == bottom_row || first_col == last_col)
        break;
        top_row += 1;
        bottom_row -= 1 ;
        first_col++;
        last_col--;
        }
        return arr;

    }
}