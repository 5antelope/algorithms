/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n1.next!=null && n1.next.next!=null) {
            n1 = n1.next.next;
            n2 = n2.next;
        }
        n1 = n2.next;
        n2.next = null;
        head = sortList(head);
        n1 = sortList(n1);
        // split into 2 sublists
        return merge(head,n1);
    }
    public ListNode merge(ListNode n1, ListNode n2) {
        if (n1==null) return n2;
        if (n2==null) return n1;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (n1!=null && n2!=null) {
            if (n1.val<n2.val) {
                pointer.next = n1;
                n1 = n1.next;
            }
            else {
                pointer.next = n2;
                n2 = n2.next;
            }
            pointer = pointer.next;
        }
        if (n1!=null)   pointer.next = n1;  // common trick in linked nodes.
        else if (n2!=null)   pointer.next = n2;
        return head.next;
    }
}
