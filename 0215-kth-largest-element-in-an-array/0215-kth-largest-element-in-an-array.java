class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num:nums)
            pqMax.add(num);
        while(k>1)
        {
            pqMax.poll();
            k--;
        }
    return pqMax.poll();
    }
}