//https://leetcode.com/problems/lru-cache/

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node dummy = new Node(0,0);
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.val = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.pre = dummy;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }
    
    private void remove(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    
    public void setHead(Node n){
        n.next = dummy.next;
        n.next.pre = n;
        dummy.next = n;
        n.pre = dummy;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.val = value;
            remove(old);
            setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size() >= capacity){
                map.remove(dummy.pre.key);
                remove(dummy.pre);
            }
            setHead(created);
            map.put(key, created);
        }
    }
}
