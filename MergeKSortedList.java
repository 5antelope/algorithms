/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    ListNode node = new ListNode(0);
    ListNode header = node;
    public ListNode mergeKLists(List<ListNode> lists) {
        int len = lists.size();
        if (len<1)  return null;
        PriorityQueue queue = new PriorityQueue();
        for (int i=0; i<len; i++) {
            ListNode n = lists.get(i);
            while(n!=null) { 
                queue.offer(n.val);
                n = n.next;
            }
        }
        while (queue.peek()!=null) {
            node.next = new ListNode((Integer)queue.poll());
            node = node.next;
        }
        return header.next;
    }
}

// 2nd. solution, a little slower but much less extra space used
public class Solution {
    ListNode node = new ListNode(0);
    ListNode header = node;
    public ListNode mergeKLists(List<ListNode> lists) {
        int len = lists.size();
        if (len<1)  return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val-n2.val;
            }
        });
        for (ListNode n: lists) {
            if (n!=null)
                queue.offer(n);
        }    
        while (queue.size()>0) {
            ListNode tmp = queue.poll();
            node.next = tmp;
            node = node.next;
            if (tmp.next!=null)
                queue.offer(tmp.next);
        }
        return header.next;
    }
}
