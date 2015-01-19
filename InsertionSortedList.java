public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null)  return head;
        ListNode p = new ListNode(Integer.MIN_VALUE);
        p.next = head;
        head = p;
        p = head.next;
        ListNode q = head;
        while (p!=null) {
            ListNode s = head.next;
            while (s.next!= null && s.val<=p.val)
                s = s.next;
            if (s!=p) {
                ListNode tmp = s.next;
                s.next = p;
                q.next = p.next;
                p.next = tmp;
                p = q.next;
            }
            else {
                p = p.next;
                q = q.next;
            }
        }
        return head.next;
    }
}
