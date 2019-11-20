class MyHashMap {
    class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }
    
    ListNode[] map;
    int capacity;

    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 10000;
        map = new ListNode[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        if (map[idx] == null){
            map[idx] = new ListNode(-1, -1);
        }
        addToList(map[idx], key, value);
    }
    
    private void addToList(ListNode head, int key, int val){
        ListNode prev = findPrev(head, key);
        if (prev == null){
            ListNode node = new ListNode(key, val);
            node.next = head.next;
            head.next = node;
        }
        else{
            prev.next.val = val;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        ListNode prev = findPrev(map[idx], key);
        if (prev == null){
            return -1;
        }
        return prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode prev = findPrev(map[hash(key)], key);
        if (prev != null){
            prev.next = prev.next.next;
        }
    }
    
    private int hash(int key){
        return Integer.hashCode(key)%capacity;
    }
    
    private ListNode findPrev(ListNode head, int key){
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.next.key == key){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */