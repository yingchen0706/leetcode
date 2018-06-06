/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getLen(ListNode l) {
        int res = 0;
        while(l != null) {
            l=l.next;
            res++;
        }
        return res;
    } 
    private ListNode getTail(ListNode l) {
        if (l== null) {
            return l;
        }
        while (l.next!=null) {
            l = l.next;
        }
        return l;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = getLen(l1);
        int b = getLen(l2);
        ListNode root = null;
        ListNode tailR = root;
        
        int diff = Math.abs(a-b);
        if (diff != 0) {
            ListNode head = new ListNode(0);
            int cnt = diff - 1;
            ListNode tail = head;
            while (cnt > 0) {
                tail.next = new ListNode(0);
                tail = tail.next;
                cnt--;
            }
            if (a>b) {
                getTail(l2).next = head;
            } else {
                getTail(l1).next = head;
            }
        }
        int add = 0;
        while (l1 != null) {
            ListNode node = new ListNode((l1.val+ l2.val + add)%10);
            add = ((l1.val + l2.val + add) >=10) ? 1:0;
            l1 = l1.next;
            l2 = l2.next;
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
