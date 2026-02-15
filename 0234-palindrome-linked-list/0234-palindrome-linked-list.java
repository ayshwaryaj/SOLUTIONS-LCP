/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode L1 = head;                  // original
        ListNode L2 = RevLT(head);     // reversed copy

        while (L1 != null && L2 != null)
        {
            if (L1.val != L2.val)
                return false;

            L1 = L1.next;
            L2 = L2.next;
        }

        return true;
    }

    private ListNode RevLT(ListNode head)
    {
        ListNode newHead = null;

        while (head != null)
        {
            ListNode node = new ListNode(head.val); 
            node.next = newHead;
            newHead = node;
            head = head.next;
        }

        return newHead;
        }

}