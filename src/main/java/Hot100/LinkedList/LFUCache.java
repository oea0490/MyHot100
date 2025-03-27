package Hot100.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private static class DLinkedNode {
        int key;
        int val;
        int freq;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> keyToNode;
    private Map<Integer, DLinkedNode> freqToNode;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.freqToNode = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {
        DLinkedNode node = getNode(key);
        if (node == null) return -1;
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }

        if (keyToNode.size() == capacity) {
            DLinkedNode dummy = freqToNode.get(minFreq);
            DLinkedNode backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
            if (dummy.prev == dummy) {
                freqToNode.remove(minFreq);
            }
        }
        node = new DLinkedNode(key, value);
        keyToNode.put(key, node);
        pushFront(1, node);
        minFreq = 1;
    }

    private DLinkedNode getNode(int key) {
        if(!keyToNode.containsKey(key)) return null;
        DLinkedNode node = keyToNode.get(key);
        remove(node);
        DLinkedNode dummy = freqToNode.get(node.freq);
        if (dummy.prev == dummy) {
            freqToNode.remove(node.freq);
            if (minFreq == node.freq) {
                minFreq++;
            }
        }
        pushFront(++node.freq, node);
        return node;
    }

    private void pushFront(int freq, DLinkedNode node) {
        DLinkedNode dummy = freqToNode.computeIfAbsent(freq, k -> newList());
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }

    private DLinkedNode newList() {
        DLinkedNode dummy = new DLinkedNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        return dummy;
    }

    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}