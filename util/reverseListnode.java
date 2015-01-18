ListNode pre = head;
ListNode cur;
ListNode next;
pre.next = cur;
while (cur!=null) {
  next = cur.next;
  cur.next = pre;
  pre = cur;
  cur = next;
}
head.next = null;
