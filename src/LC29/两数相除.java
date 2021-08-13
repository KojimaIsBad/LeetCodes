package LC29;

public class 两数相除 {
    public static void main(String[] args) {
        System.out.println(new Solution().divide1(-2147483648,-123121));
    }
}
class Solution {
    /**
     * 减法。超时
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide0(int dividend, int divisor) {
        boolean isSameSign = false;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(dividend==0&&divisor!=0)
            return 0;
        if(dividend==0&&divisor==0)
            return Integer.MAX_VALUE;
        if((dividend>=0&&divisor>=0)||(dividend<0&&divisor<0))
            isSameSign = true;
        long x = Math.abs((long)dividend);
        long y = Math.abs(divisor);
        long res = -1;
        while (x>=0){
            res++;
            x-=y;
        }
        if(!isSameSign)
            res = -res;
        return (int)res;
    }

    /**
     * 二进制移位
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        //极端情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        //异或计算
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }
}