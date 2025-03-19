package Hot100.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //flag标记链表有无环
        Boolean flag = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag) {
            Set<ListNode> set = new HashSet<>();
            set.add(slow);
            slow = slow.next;
            while (slow != fast) {
                set.add(slow);
                slow = slow.next;
            }
            ListNode cur = head;
            while (!set.contains(cur)) {
                cur = cur.next;
            }
            return cur;
        }
        return null;
    }
}
