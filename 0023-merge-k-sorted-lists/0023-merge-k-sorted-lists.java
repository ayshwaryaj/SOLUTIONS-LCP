/*class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        else if(lists.length == 1)
            return lists[0];
        else{
        ListNode MergedList = lists[0];
        for(int i = 1; i<lists.length; i++)
        {
            ListNode list2 = lists[i];
            MergedList = MKL(MergedList, list2);
        }
        return MergedList;}
    }
    private ListNode MKL(ListNode list1, ListNode list2)
    {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if (list1.val <= list2.val) {
            list1.next = MKL(list1.next, list2);
            return list1;
        } else {
            list2.next = MKL(list1, list2.next);
            return list2;
        }
    }
}


upon Optimizing */

/* 
*
*
*
OPTIMIZING USING DIVIDE & CONQUER APPROACH

Space complexity is still high 
*
*
*

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;

        ListNode l1 = divide(lists, left, mid);
        ListNode l2 = divide(lists, mid + 1, right);

        return merge(l1, l2);   
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
 
*
*
*
Reducing Space complexity with iterative technique
*
*
*
*/

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;

        return head;
    }
}
