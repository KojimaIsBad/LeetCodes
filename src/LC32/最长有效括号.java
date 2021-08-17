package LC32;

import java.util.Stack;

public class 最长有效括号 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParenthesesDP(")()())"));
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        var stack = new Stack<Integer>();
        stack.push(-1);
        var i=0;
        while (i<s.length()){
            char cur = s.charAt(i);
            if(cur=='(')
                stack.push(i);
            else {
//                if(!stack.empty()){
//                    var prev = stack.pop();
//                    max = Math.max(i-prev+1,max);
//                }
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(i-stack.peek(),max);
                }

            }
            i++;
        }
        return max;
    }

    /**
     * 贪心算法
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        int left =0, right=0, max=0;
        for(var i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(')
                left++;
            else
                right++;
            if(left==right)
                max=Math.max(max,left+right);
            if(left<right){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(var i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='(')
                left++;
            else
                right++;
            if(left==right)
                max=Math.max(max,left+right);
            if(left>right){
                left = 0;
                right = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int longestValidParenthesesDP(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        //初始化dp数组
        for(var i=0;i<dp.length;i++)
            dp[i]=0;
        //从......))和......()两种情况考虑
        for(int i=1;i<dp.length;i++){
            //()
            if(s.charAt(i)==')'&&s.charAt(i-1)=='('){
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            }
            //))
            if(s.charAt(i)==')'&&s.charAt(i-1)==')'){
                if(i-dp[i-1]>0&&s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}