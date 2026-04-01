class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums)
        {
            if(hs.contains(num))
            {
                hs.remove(num);
            }
            else
                hs.add(num);
        }
        int n = hs.iterator().next();
        return n;
    }
}