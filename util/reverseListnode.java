... {
  ListNode pre = head;
  ListNode cur = pre.next;
  ListNode next;
  while (cur!=null) {
    next = cur.next;
    cur.next = pre; // from 'pre -> cur' to 'pre <- cur'
    pre = cur;
    cur = next;
  }
  // now cur point at the start of reversed list
  head.next = null;
}
