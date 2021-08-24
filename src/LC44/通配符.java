package LC44;

public class 通配符 {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("acdcb", "a*c?b"));
    }
}

class Solution {
    //根据正则表达式匹配修改
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                //是星号
                if (p.charAt(j - 1) == '*') {
                    //*当作0个字符，或抵消s的1个字符
                    dp[i][j] = dp[i][j - 1] || ((i > 0) && dp[i - 1][j]);
                }
                //不是星号
                else {
                    if (match(s, p, i, j))
                        dp[i][j] = dp[i - 1][j - 1];
                }

            }
        }

        return dp[m][n];
    }

    /**
     * 根据LeetCode题解改进
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchV2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (var i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        for (int i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                //是星号
                if (p.charAt(j - 1) == '*') {
                    //*当作0个字符，或抵消s的1个字符
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                //不是星号
                else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

            }
        }

        return dp[m][n];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '?')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}