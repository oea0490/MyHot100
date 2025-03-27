package Hot100.LinkedList;

import java.util.HashMap;
import java.util.Map;

//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}

public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        // 记录原链表节点和索引
        Map<Node, Integer> NtoImap = new HashMap<>();
        // 记录新链表索引和节点
        Map<Integer, Node> ItoNmap = new HashMap<>();
        int index = 0;
        Node cur = head;
        Node curCopy = dummy;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            curCopy.next = newNode;
            NtoImap.put(cur, index);
            ItoNmap.put(index, newNode);
            index++;
            curCopy = curCopy.next;
            cur = cur.next;
        }
        // 二次遍历更新random指针
        cur = head;
        curCopy = dummy.next;
        while (cur != null) {
            if (cur.random != null){
                int randomIndex = NtoImap.get(cur.random);
                curCopy.random = ItoNmap.get(randomIndex);
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return dummy.next;
    }
}
