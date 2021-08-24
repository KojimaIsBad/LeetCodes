package LC38;

public class 外观数列 {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
//        System.out.println(new Solution().decode(21));
    }
}
class Solution {
//    public String decode(int n) {
////        int start = 0, end = 0;
//        String val = String.valueOf(n);
//        StringBuilder sb = new StringBuilder();
//        int count = 1, p=1;
//        char curVal = val.charAt(0);
//        boolean end = false;
//        while (!end){
//            if(p==val.length()){
//                sb.append(count);
//                sb.append(curVal);
//                break;
//            }
//            if(val.charAt(p)==curVal){
//                count++;
//
//            }
//            else if(p==val.length()||val.charAt(p)!=curVal){
//                sb.append(count);
//                sb.append(curVal);
//                curVal = val.charAt(p);
//                count = 1;
//            }
//            p++;
//        }
//        return sb.toString();
//    }

    public String decode(String val) {
//        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        int count = 1, p=1;
        char curVal = val.charAt(0);
        boolean end = false;
        while (!end){
            if(p==val.length()){
                sb.append(count);
                sb.append(curVal);
                break;
            }
            if(val.charAt(p)==curVal){
                count++;

            }
            else if(p==val.length()||val.charAt(p)!=curVal){
                sb.append(count);
                sb.append(curVal);
                curVal = val.charAt(p);
                count = 1;
            }
            p++;
        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        if(n==1)
            return String.valueOf(1);
        return decode(countAndSay(n-1));
    }
}