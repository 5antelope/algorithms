public class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null)  return;
        int len = 1;
        ListNode tail = head;
        while (tail.next!=null) { tail=tail.next; len++;}
        int dif = len;
        ListNode cur = head;
        for (int i=0; i<(len-1)/2; i++) {
            tail = cur;
            for (int c=0; c<dif-1; c++)
                tail = tail.next;
            ListNode tmp = cur.next;
            cur.next = tail;
            tail.next = tmp;
            dif -= 2;
            cur = tmp;
        }
        if (len>2 && len%2==0)   cur.next.next=null;
        else if (len>2 && len%2==1)    cur.next=null;
    }
}
