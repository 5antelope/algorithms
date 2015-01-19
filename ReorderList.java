/**
 * List node 3 general questions:
 *      -. reverse list
 *      -. fast/ slow pointer
 *      -. merge lists
 */
public class Solution {
    // O(n^2) solutin, exceed time limit
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
    // AC!
    public void reorderList(ListNode head) {
        if (head==null || head.next==null)  return;
        ListNode mid=head, tail=head;
        while (tail.next!=null && tail.next.next!=null){
            mid = mid.next;
            tail = tail.next.next;
        }
        // reverse 2nd. half
        ListNode pre = mid.next;
        ListNode cur = pre.next;
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        mid.next.next = null; // clean up tails
        mid.next = null;
        cur = pre;
        pre = head;
        // merge up
        while (cur!=null) {
            ListNode tmp1 = pre.next;
            ListNode tmp2 = cur.next;
            pre.next = cur;
            cur.next = tmp1;
            pre = tmp1;
            cur = tmp2;
        }
    }
}
