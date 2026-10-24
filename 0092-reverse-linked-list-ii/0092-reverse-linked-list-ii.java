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
    public ListNode reverse(ListNode leftPos , ListNode rightPos){
        rightPos.next = null;
        ListNode p1 = null;
        ListNode p2 = leftPos;
        ListNode p3 = leftPos.next;

        while(p2!=null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if(p3!=null) p3 = p3.next;
        }

        return rightPos;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        if(head.next==null) return head;
        if(left==right) return head;


        // finding the leftPos
        ListNode leftPos = head;
        int i = 1;
        while(i!=left){
            leftPos = leftPos.next;
            i++;
        }

        // finding the rightPOs
        ListNode rightPos = head;
        int j = 1;
        while(j!=right){
            rightPos = rightPos.next;
            j++;
        }

        // pointing the tail  node right after the rightPos;
        ListNode tail = rightPos.next;

        // pointing the left  node right before the leftpos;
        ListNode Left_prev = head;
        while(Left_prev!=leftPos && Left_prev.next!=leftPos){
            Left_prev = Left_prev.next;
        }



        ListNode rp = reverse(leftPos , rightPos);

        // after reversal joining the leftPos and rightPos at correct pos
        
        if(head==leftPos && tail==rightPos) {
            leftPos.next = null;
            return rp;
        }

        if(head==leftPos){
            leftPos.next = tail;
            return rp;
        }


        else{
            Left_prev.next = rp;
            leftPos.next = tail;
            return head;
        }
    }
}