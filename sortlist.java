/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // find mid
        ListNode p = head, q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        //p points to mid
        ListNode nextHalfHead = p.next;
        p.next = null;
        head = mergeSort(head);
        nextHalfHead = mergeSort(nextHalfHead);
        
        return merge(head, nextHalfHead);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode p1 = left, p2 = right;
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                p.next = p2;
                break;
            } else if (p2 == null) {
                p.next = p1;
                break;
            } else {
                p.next = (p1.val <= p2.val ? p1 : p2);
                p = p.next;
                if (p1.val <= p2.val) {
                    p1 = p1.next;
                } else {
                    p2 = p2.next;
                }
            }
        }
        return head.next;
    }
}
