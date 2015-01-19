public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode tmp = new ListNode(head.val-1);
        tmp.next = head;
        ListNode p   = tmp;
        ListNode newHeader = new ListNode(0);
        while (p!=null && p.next!=null) {
            while (p.next!=null && p.val == p.next.val)
                p = p.next;
            p = p.next;
            newHeader.next = p;
            newHeader = newHeader.next;
        }
        return newHeader.next;
    }
}
