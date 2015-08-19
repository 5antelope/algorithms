public class LRUCache {
    class CacheNode {
        CacheNode pre, next;
        int val;
        int key;
        CacheNode(int key, int val) {this.key = key; this.val = val;}
    }

    HashMap<Integer, CacheNode> cache;
    CacheNode head, tail;
    int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<Integer, CacheNode>(capacity);
        head = null; tail = null;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        CacheNode node = cache.get(key);
        if (node==head) return node.val;
        if (node==tail) tail = tail.pre;
        else {node.next.pre = node.pre;}
        node.pre.next = node.next;
        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
        return node.val;
    }

    public void set(int key, int value) {
        if (!cache.containsKey(key)) {
            CacheNode node = new CacheNode(key, value);
            if (size==capacity) {
                cache.remove(tail.key);
                tail = tail.pre;
                if (tail!=null) tail.next = null;
            }
            if (tail==null) tail=node;
            node.next = head;
            if (head!=null) head.pre = node;
            head = node;
            cache.put(key, node);
            size = size==capacity?capacity:size+1;
        }
        // update cache with same key
        else {
            CacheNode node = cache.get(key);
            node.val = value;
            if (node==head) return;
            if (node==tail) tail = tail.pre;
            else {node.next.pre = node.pre;}
            node.pre.next = node.next;
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;
        }
    }
}
