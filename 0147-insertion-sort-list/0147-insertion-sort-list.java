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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head.next;  // start from second node
        ListNode sortedEnd = head;     // end of the sorted part

        while (current != null) {
            if (current.val >= sortedEnd.val) {
                sortedEnd = current;
                current = current.next;
            } else {
                sortedEnd.next = current.next;

                if (current.val <= head.val) {
                    current.next = head;
                    head = current;
                } else {
                    ListNode temp = head;
                    while (temp.next.val < current.val) {
                        temp = temp.next;
                    }
                    current.next = temp.next;
                    temp.next = current;
                }

                current = sortedEnd.next;
            }
        }

        return head;
    }
}
