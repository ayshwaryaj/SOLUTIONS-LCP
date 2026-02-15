class Solution {
    public double myPow(double x, int n) {
        double y;
        if(n==0)
            return 1;
        else if (n<0)
        {
            if(Math.abs(n)==1)
                return 1/x;
            if(Math.abs(n)%2 == 0)
            {
                y = myPow(1/x, n/2);
                return 1/y * 1/y; 
            }
            else
            {
                y= myPow(1/x, n/2);
                return (1/x)*(1/y)*(1/y);
            }
        }
        else
        {
            if(n==1)
                return x;
            if(n%2 == 0)
            {
                y = myPow(x, n/2);
                return y * y; 
            }
            else
            {
                y= myPow(x, n/2);
                return x*y*y;
            }
        }
    }
}