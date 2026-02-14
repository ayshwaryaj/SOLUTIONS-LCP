/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode p, q, key, pkey;
        p = head;
        int n=0;
        if((head == null)|| head.next == null)
            return head;
        key = head.next;
        while(p.val<key.val)
            {
                p=p.next;
                key=key.next;
            }
        InsertionSort(head, key);
        return head;
    }

    private ListNode InsertionSort(ListNode head, ListNode key)
    {
        ListNode q=head;
        ListNode t=head;
        ListNode s;
        ListNode r=key.next;
        while(q.val<key.val)
        {
            t=q;
            q=q.next;
        }
        if(q.val>key.val)
        {
            if(q==head)
            {
                q.next = key.next;
                key.next= head;
                head = key;            
            }
            else
            {
                q.next = key.next;
                t.next=key;
                key.next = q;
            }
        }
        s=head;
        while(s!= null)
        {
            System.out.print(s.val);
            s=s.next;
        }
        System.out.println();
        if (r!=null)
        {
           // r=r.next;
            InsertionSort(head, r);
        }
        return head;
    }
}*
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head.next;  // start from second node
        ListNode prevCurrent = head;   // node before current

        while (current != null) {
            if (current.val >= prevCurrent.val) {
                // Already in order, move forward
                prevCurrent = current;
                current = current.next;
            } else {
                // Need to insert current into sorted portion
                prevCurrent.next = current.next;  // remove current

                // Insert current into sorted part
                if (current.val < head.val) {
                    // Insert at head
                    current.next = head;
                    head = current;
                } else {
                    // Insert somewhere in middle
                    ListNode p = head;
                    while (p.next.val < current.val) {
                        p = p.next;
                    }
                    current.next = p.next;
                    p.next = current;
                }

                // Move to next node
                current = prevCurrent.next;
            }
        }

        return head;
    }
}
*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // base case: empty or single node
        if (head == null || head.next == null) return head;

        // recursively sort the rest of the list
        ListNode sorted = insertionSortList(head.next);

        // insert head into the sorted list
        return insertIntoSorted(sorted, head);
    }

    private ListNode insertIntoSorted(ListNode head, ListNode node) {
        // insert at head
        if (node.val <= head.val) {
            node.next = head;
            return node;
        }

        // find the correct spot
        ListNode current = head;
        while (current.next != null && current.next.val < node.val) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;

        return head;
    }
}
