package Hot100.LinkedList;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            // pre -> second -> first -> second.next
            pre.next = second;
            first.next = second.next;
            second.next = first;
            pre = first;
        }
        return dummy.next;
    }
}
