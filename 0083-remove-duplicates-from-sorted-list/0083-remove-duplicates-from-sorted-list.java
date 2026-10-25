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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;

        ListNode left = head;

        while(left!=null && left.next!=null){
            if(left.val==left.next.val){
               left.next = left.next.next;
            }
            else left = left.next;
        }
        return head;
    }
}