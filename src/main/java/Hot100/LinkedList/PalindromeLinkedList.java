package Hot100.LinkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean flag = true;
        //快慢指针，快指针走到末尾，慢指针走到中间
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转后半部分链表
        ListNode reversedHead = slow.next;
        slow.next = null;
        reversedHead = new ReverseLinkedList().reverseList(reversedHead);
        //对原链表前半部分 和 反转的后半部分进行比较
        ListNode p = head;
        ListNode q = reversedHead;
        while (p != null && q != null) {
            if (p.val != q.val) {
                flag = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        //恢复原链表
        reversedHead = new ReverseLinkedList().reverseList(reversedHead);
        slow.next = reversedHead;
        return flag;
    }
}