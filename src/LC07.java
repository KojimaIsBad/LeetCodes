public class LC07 {
}

//整数反转
class Solution07 {
    /**
     * 字符串方法
     * @param x
     * @return
     */
    public int reverse01(int x) {
            boolean positive = true;
            if (x <= Integer.MIN_VALUE || x > Integer.MAX_VALUE)
                return 0;
            if (x < 0) {
                positive = false;
                x = -x;
            }
            char[] cs = Integer.toString(x).toCharArray();
            boolean isFirstZero = true;
            StringBuilder sb = new StringBuilder();
            for (int i = cs.length - 1; i >= 0; i--)
                if((cs[i]=='0'&&isFirstZero)||cs[i]!=0)
                    sb.append(cs[i]);
                else
                    isFirstZero = false;
            String curs = sb.toString();
            String maxs = Integer.toString(Integer.MAX_VALUE);
            char[] ccurs = curs.toCharArray();
            char[] cmaxs = maxs.toCharArray();
            if(ccurs.length<cmaxs.length)
                return positive?Integer.parseInt(curs):-Integer.valueOf(curs);
            else if (positive)
                for(int i=0;i<cmaxs.length;i++){
                    if (ccurs[i]>cmaxs[i])
                        return 0;
                    if ((ccurs[i]<cmaxs[i])||(i==maxs.length()-1&&ccurs[i]<=cmaxs[i]))
                        return Integer.valueOf(curs);
                }
            else
                for(int i=0;i<maxs.length();i++){
                    if (ccurs[i]>cmaxs[i])
                        return 0;
                    if ((ccurs[i]<cmaxs[i])||(i==maxs.length()-1&&ccurs[i]<=cmaxs[i]+1))
                        return Integer.valueOf("-"+curs);
                }


            return 0;
    }

    /**
     * 数学方法
     * @reference https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x!=0){
            //不等式不成立，越界
            if(rev>Integer.MAX_VALUE/10||rev<Integer.MIN_VALUE/10){
                return 0;
            }
            int digit = x%10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}