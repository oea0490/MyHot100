package Hot100.LinkedList;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if (p == null){
                p = headB;
            }else{
                p = p.next;
            }
            if (q == null){
                q = headA;
            }else{
                q = q.next;
            }
            if (p == null && q == null){
                return null;
            }
            if (p == q){
                return p;
            }
        }
        return p;
    }
}
