package Hot100.LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表分为两段
        ListNode tmp = slow.next;
        slow.next = null;
        // 递归进行归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null){
            cur.next = left;
        }
        if (right != null){
            cur.next = right;
        }
        return dummy.next;
    }
}
