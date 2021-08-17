package LC28;

public class IndexOf {
    public static void main(String[] args) {
//        System.out.println(new Solution().strStr("aaaaa","bba"));
        int[] next = new Solution().getNextMap("ABABAD");
        System.out.println("");
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        if(needle.length()>haystack.length())
            return -1;
//        int hp = 0,np=0;
//        while (hp<haystack.length()){
//            if(haystack.charAt(hp)==)
//        }
        StringBuilder sb = new StringBuilder(haystack.substring(0,needle.length()));
        for(var i=0;i<=haystack.length()-needle.length();i++){
            if(sb.toString().equals(needle)){
                return i;
            }

            sb.deleteCharAt(0);
            if(needle.length()+i<haystack.length())
                sb.append(haystack.charAt(needle.length()+i));
        }
        return -1;
    }

    /**
     * 法2 KMP
     */
    public int strStrKMP(String haystack, String needle){
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public int[] getNextMap(String pattern){
        char[] cs = pattern.toCharArray();
        int len = pattern.length();
        int j = 0;
        int[]  next =new int[len+1];
        next[j]=-1;
        int i = next[j];
        while (j<len){
            if(i==-1||cs[i]==cs[j]){
                i++;
                j++;
                next[j]=i;
            }else {
                i = next[i];
            }
        }
        return next;
    }
}
