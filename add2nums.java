/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = null;
        ListNode tailR = root;
        
        int add = 0;
        while (p1!=null || p2!=null) {
            int x = p1 !=null?p1.val:0;
            int y = p2 !=null?p2.val:0;
            ListNode node = new ListNode((x+y + add)%10);
            add = ((x+y + add) >=10) ? 1:0;
            if (p1!=null) {
                p1 = p1.next;
            }
            if (p2!=null) {
                p2 = p2.next;
            }
            if (root == null) {
                root = node;
                tailR = root;
            } else {
                tailR.next = node;
                tailR = node;
            }
        }
        if (add > 0) {
            tailR.next = new ListNode(1);
        }
        return root;
    }
}
