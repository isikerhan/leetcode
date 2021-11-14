class LRUCache {
    
    private static class CacheNode {
        private final int key;
        private int val;
        private CacheNode next;
        private CacheNode prev;
        
        private CacheNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    private CacheNode head = null;
    private CacheNode tail = null;
    private final Map<Integer, CacheNode> cache = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        CacheNode node = cache.get(key);
        if (node == null)
            return -1;
        use(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        CacheNode node = cache.get(key);
        if (node != null) {
            use(node);
            node.val = value;
        } else {
            CacheNode newNode = new CacheNode(key, value);
            cache.put(key, newNode);
            addFirst(newNode);
            if (cache.size() > capacity) {
                CacheNode removed = removeLast();
                cache.remove(removed.key);
            }
        }
    }
    
    private void use(CacheNode node) {
        remove(node);
        addFirst(node);
    }
    
    private void addFirst(CacheNode node) {
        node.next = node.prev = null;
        if (head == null) {
            head = tail = node;
        } else if (head == tail) {
            tail.prev = node;
            node.next = tail;
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    private void remove(CacheNode node) {
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        if (head == node)
            head = node.next;
        if (tail == node)
            tail = node.prev;
        node.next = node.prev = null;
    }
    
    private CacheNode removeLast() {
        CacheNode removed = tail;
        remove(removed);
        return removed;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */