class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        int diff = 0;
        int Minpos = 0;
        int x=0;
        for(int i=1;i<prices.length; i++)
        {
            if(min>prices[i])
            {
                min=prices[i];
                Minpos=i;
            }
            else
            {
                if(prices[i]-min > diff)
                {
                    diff= prices[i]-min;
                    System.out.print("diff is="+ diff);
            
                }
               }
        }
        if(Minpos<prices.length-1)
            max = prices[Minpos+1];
        else
            return diff;
        for(int j= Minpos; j<prices.length; j++)
           {
                if(prices[j]>max)
                    max=prices[j];
           }
        
        if(max>0)
        {
            x = max - min;
        }
         if(x>diff ) 
            diff = x;
        
        return diff;
   }
}