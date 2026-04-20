class Solution {
    public List<Integer> countSmaller(int[] nums) 
    {
        List<Integer> smallerToRight = new LinkedList<>();
        List<Integer> sortedList = new ArrayList<>();
        for(int i = nums.length-1; i>=0; i--)
        {
            int index = insertAndGetIndex(sortedList, nums[i]);
            smallerToRight.add(0,index);
        }
        return smallerToRight;
    }
    private int insertAndGetIndex(List<Integer> sortedList, int num)
    {
        int low = 0;
        int high = sortedList.size()-1;
        if(sortedList.isEmpty() || num<sortedList.get(0))
        {
            sortedList.add(0,num);
            return 0;
        }
        if(num>sortedList.get(high))
        {
            sortedList.add(num);
            return high+1;
        }
        while(high-low > 1)
        {
            int mid = (low+high)/2;
            if(num<=sortedList.get(mid))
            {
                high = mid;
            }
            else
            {
                low=mid;
            }
        }
            if(num<=sortedList.get(low))
            {
                sortedList.add(low, num);
                return low;
            }
            else if(num> sortedList.get(high))
            {
                sortedList.add(high+1, num);
                return high+1;
            }
            else
            {
                sortedList.add(high, num);
                return high;
            }
        }
    }
/*class Solution {
    int [] count;
    public List<Integer> countSmaller(int[] nums) {
       List<Integer>result = new ArrayList<>();
       count = new int[nums.length];
       int [] originalIndex = new int[nums.length];

       for(int i=0; i <nums.length; i++)
        {
            originalIndex[i]=i;
        }
        sort(nums, originalIndex, 0, nums.length-1);
        for(int i=0; i<nums.length; i++)
        {
            result.add(count[i]);
        }
        return result;
    }
    private void sort(int[]arr, int[]originalIndex, int l, int r)
    {
        if(l<r)
        {
            int mid=(l+r)/2;
            sort(arr, originalIndex, l, mid);
            sort(arr, originalIndex, mid+1,r);
            merge(arr, originalIndex, l, mid,r);
        }
    }
    private void merge(int[] arr, int[] originalIndex, int left, int mid, int right)
    {
        int lArrSize=mid-left+1;
        int rArrSize = right-mid;

        int [] lArr = new int[lArrSize];
        int [] rArr = new int[rArrSize];

        for(int i=0; i<lArrSize; i++)
        {
            lArr[i] = originalIndex[left+i];
        }
        for(int i=0; i<rArrSize; i++)
        {
            rArr[i]=originalIndex[i+mid+1];
        }
        int i=0, j=0, k=left, rightCount=0;
        while(i<lArrSize && j<rArrSize)
        {
            if(arr[lArr[i]] <= arr[rArr[j]])
            {
                originalIndex[k] = lArr[i];
                count[lArr[i]] += rightCount;
                i++;
            }
            else
            {
                originalIndex[k] = rArr[j];
                rightCount++;
                j++;
            }
            k++;
        }
        while(i<lArrSize)
        {
            originalIndex[k] = lArr[i];
            count[lArr[i]] +=rightCount;
            i++;
            k++;
        }
        while(j<rArrSize)
        {
            originalIndex[k] =  rArr[j];
            j++;
            k++;
        }
    }
}*/