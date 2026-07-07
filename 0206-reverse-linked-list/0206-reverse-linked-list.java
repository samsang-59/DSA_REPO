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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev = null , curr = head , Next = head.next;
        while(Next!=null){
            curr.next = prev;
            prev = curr;
            curr = Next;
            Next = curr.next;
        }
        
        curr.next = prev;
        head = curr;
        return head;
    }
}