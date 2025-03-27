package Hot100.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addToHead(node);
            size ++;
            while (size > capacity){
                DLinkedNode removeNode = removeTail();
                map.remove(removeNode.key);
                size --;
            }
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
