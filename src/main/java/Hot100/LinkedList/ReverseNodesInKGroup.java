package Hot100.LinkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            //原顺序 pre -> start -> end -> next
            ListNode start = pre.next;
            ListNode end = start;
            for (int i = 1; i < k; i++) {
                end = end.next;
                if (end == null) {
                    return dummy.next;
                }
            }
            ListNode next = end.next;
            end.next = null;
            //新顺序 pre -> end -> start -> next
            pre.next = new ReverseLinkedList().reverseList(start);
            start.next = next;
            pre = start;
        }
        return dummy.next;
    }
}
