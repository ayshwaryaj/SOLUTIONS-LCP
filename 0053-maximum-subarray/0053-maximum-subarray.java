/*class Solution {

    public int maxSubArray(int[] nums) {
        return msa(nums, 0, nums.length - 1);
    }

    private int msa(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];

        int m = l + (r - l) / 2;

        int leftMax = msa(nums, l, m);
        int rightMax = msa(nums, m + 1, r);
        int crossMax = sum(nums, l, m, r);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int sum(int[] nums, int l, int m, int r) {

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = m; i >= l; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}*/

class Solution {

    public int maxSubArray(int[] nums) {
        int CS = 0, MS = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            CS += nums[i];
            MS = Math.max(CS,MS);
            if(CS < 0)
                CS=0;
        }
        return MS;
    }
}