public class LC14 {
}
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int sum = strs.length;
        char[][] css = new char[sum][];
        for(int i=0;i<sum;i++)
            css[i] = strs[i].toCharArray();
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<sum;i++)
            minLen = Math.min(minLen,css[i].length);
        A:for(int i=0;i<minLen;i++){
            for(int j=0;j<sum;j++){
                if(css[j][i]!=css[0][i])
                    break A;
            }
            sb.append(css[0][i]);
        }
        return sb.toString();




    }
}