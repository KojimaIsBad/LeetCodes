package LC50;

public class Pow {
    public static void main(String[] args) {
//        int xx= Integer.MIN_VALUE;
//        System.out.println(xx);
        var res = new Solution().myPow(2.00000, -2147483648);
        System.out.println(res);
    }
}
//2.00000

//-2147483648
class Solution {
//    public double myPow(double x, int n) {
//        if (x == 1)
//            return 1;
//        if (x == 0)
//            return 0;
//        if (x == -1) {
//            if (n % 2 == 0)
//                return 1;
//            else
//                return -1;
//        }
//        double res = 1;
//        if (n >= 0)
//            for (var i = 0; i < Math.abs(n); i++) {
//                res *= x;
//            }
//        else {
//            if(n==Integer.MIN_VALUE){
//                for (var i = 0; i < Integer.MAX_VALUE; i++) {
//                    res /= x;
//                }
//                res/=x;
//            }
//            else {
//                for (var i = 0; i < Math.abs(n); i++) {
//                    res /= x;
//                }
//            }
//        }
//        return res;
//    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


}