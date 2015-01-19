/**
 * question about list node. 3 references need to create/ reserve:
 * 
 *      1. head node
 *      2. tail node / mid node
 *      3. previous node
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode p = new ListNode(0); // put results
        p.next = head;
        head = p; // still use head to point begin of list
        ListNode pre = p; // need a ref to previous node
        while (p!=null) {
            while (p.next!=null && p.val==p.next.val)
                p = p.next;
            if (pre.next==0)    pre = pre.next;
            else pre.next = p.next;
            p = p.next;
        }
        return header.next;
    }
}
