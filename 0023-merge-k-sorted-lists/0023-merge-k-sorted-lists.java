class Solution {
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
