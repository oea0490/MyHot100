package Hot100.LinkedList;

public class MergeKSortedLists {
    public ListNode mergeKListsRecursively(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        ListNode leftNode = merge(lists, left, mid);
        ListNode rightNode = merge(lists, mid + 1, right);
        return new MergeTwoSortedLists().mergeTwoListsRecursively(leftNode, rightNode);
    }
    public ListNode mergeKListsIteratively(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int n = lists.length;
        while (true) {
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            if (minNode != null) {
                cur.next = minNode;
                cur = cur.next;
                lists[minIndex] = lists[minIndex].next;
            }else{
                break;
            }
        }
        return dummy.next;
    }
}
