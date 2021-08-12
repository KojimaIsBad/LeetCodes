import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class LC09 {
//    public static void main(String[] args) {
//
//        throw new OutOfMemoryError("内存溢出");
//    }

}

class Solution09 {
    /**
     * 判断是否为回文数
     * @param x
     * @return
     */
    public boolean isPalindromeWithStr(int x) {
        if(x<0)
            return false;
        char[] cs = String.valueOf(x).toCharArray();
        int lp = 0, rp = cs.length-1;
        while(lp<=rp){
            if(cs[lp]==cs[rp]){
                lp++;
                rp--;
            } else
                return false;
        }
        return true;
    }

    /**
     * 不用字符串
     * @param x
     * @return
     */
    public boolean isPalindrome02(int x) {
        if(x<0)
            return false;
        ArrayList<Integer> list = new ArrayList<>();
        while(x!=0){
            int digit = x % 10;
            list.add(digit);
            //这里如果连续装入相同的数，是否对应同一个包装器对象？
            x/=10;
        }
        for(int i=0;i<list.size();i++){
            if(!list.get(i).equals(list.get(list.size()-1-i)))
                return false;
        }
        return true;
    }

    /**
     * 不用字符串
     * @param x
     * @return
     */
    public boolean isPalindrome3(int x) {
        if(x<0)
            return false;
        int count = 0;
        int y = x;
        while(x!=0){
            x/=10;
            count++;
        }
        int[] is = new int[count];
        for(int i=0;i<count;i++){
            is[i] = y % 10;
            y/=10;
        }
        for(int i=0;i<count/2;i++)
            if(is[i]!=is[is.length-1-i])
                return false;


        return true;
    }

    /**
     * 不用字符串
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int count = 0;
        int y = x;
        while(x!=0){
            x/=10;
            count++;
        }
        int[] is = new int[count];
        for(int i=0;i<count/2;i++){
            is[i] = y % 10;
            y/=10;
        }
        if(count%2==1)
            y/=10;
        for(int i=0;i<count/2;i++,y/=10)
            if(is[count/2-1-i]!=y%10)
                return false;


        return true;
    }
}