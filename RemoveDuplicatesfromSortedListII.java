public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode newHeader = new ListNode(head.val-1); // put results
        ListNode temp = head;
        ListNode p = newHeader;
        while (temp!=null) {
            boolean dup = false;
            while (temp.next!=null && temp.val==temp.next.val){
                dup = true;
                temp = temp.next;
            }
            if (!dup)   {p.next = new ListNode(temp.val); p = p.next; temp = temp.next;}
            else temp = temp.next;
        }
        return newHeader.next;
    }
}
