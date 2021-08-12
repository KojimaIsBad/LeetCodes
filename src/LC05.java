public class LC05 {
//    public static void main(String[] args) {
//        System.out.println(new Solution05().longestPalindrome3("aacabdkacaa"));
//    }
}

// 最长回文子串


class Solution05 {
    /**
     * 法1 中心扩散法
     *  使用了Double类型变量
     * @param s
     * @return
     */
    public String longestPalindrome01(String s) {
        int maxL = Integer.MIN_VALUE;
        double maxIndex = 0;
        for (double i = 0; i < s.length(); i += 0.5) {
            int curL;
            double step;
//            System.out.println(Double.toString(i));
            if (i%1==0.0) {
                curL = 1;
                step = 1;
            } else {
                curL = 0;
                step = 0.5;
            }
            while (i - step >= 0 && i + step < s.length()) {
//                System.out.println("left  "+s.charAt((int) (i - step)));
//                System.out.println("Right "+s.charAt((int) (i + step)));
                if (s.charAt((int) (i - step)) == s.charAt((int) (i + step))){
                    curL += 2;
                } else
                    break;
                step += 1;
            }
            if (curL > maxL) {
                maxL = curL;
                maxIndex = i;
            }
        }
        int beginIndex, endIndex;
        if (maxIndex % 1 == 0.0) {
            beginIndex = (int) (maxIndex - maxL / 2);
            endIndex = (int) (maxIndex + maxL / 2);
        } else {
            beginIndex = (int) (maxIndex - maxL / 2 + 0.5);
            endIndex = (int) (maxIndex + maxL / 2 - 0.5);
        }

        return s.substring(beginIndex, endIndex+1);


    }

    public String longestPalindrome(String s){
        int len = s.length();
        int maxL = Integer.MIN_VALUE;
        int beginIndex = 0;
        if(len<2)
            return s;
        for(int i=0;i<len-1;i++){
            int len1 = calPalindrome(s,i,i);
            int len2 = calPalindrome(s,i,i+1);
            int curL = Math.max(len1,len2);
            if(curL>maxL){
                maxL = curL;
                beginIndex = i - (curL-1)/2;
            }
        }
        return s.substring(beginIndex,beginIndex+maxL);
    }

    private int calPalindrome(String s,int left,int right){
        int i = left, j = right;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
    public String longestPalindrome3(String s){
        int len = s.length();
        int maxL = Integer.MIN_VALUE;
        int beginIndex = 0;
        char[] cs = s.toCharArray();
        if(len<2)
            return s;
        for(int i=0;i<len-1;i++){
            int len1 = calPalindrome1(cs,len,i,i);
            int len2 = calPalindrome1(cs,len,i,i+1);
            int curL = Math.max(len1,len2);
            if(curL>maxL){
                maxL = curL;
                beginIndex = i - (curL-1)/2;
            }
        }
        return s.substring(beginIndex,beginIndex+maxL);
    }


    private int calPalindrome1(char[] cs, int len, int left, int right){
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (cs[i] == cs[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }

}