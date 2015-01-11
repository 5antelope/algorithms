public class Solution {
    // iterative
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        while (true) {
            if (l1==null) {
                cur.next = l2;
                break;
            }
            if (l2==null) {
                cur.next = l1;
                break;
            }
            if (l1.val<l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
    
    // recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val<l2.val){
            node = l1;
            node.next = mergeTwoLists(l1.next, l2);
        }
        else{
            node = l2;
            node.next = mergeTwoLists(l1, l2.next);
        }
        return node;
    }
}
}
