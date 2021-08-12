package LC20;

import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid(""));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i=0;
        while (i<s.length()){
            //统一对左括号进栈
            if (s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            }else {
                //发现右括号
                if(stack.empty())
                    return false;
                char curLeft = stack.peek();
                char curRight = s.charAt(i);
                if((curLeft=='{'&&curRight=='}')||(curLeft=='('&&curRight==')')||(curLeft=='['&&curRight==']')){
                    stack.pop();
                }
                else
                    return false;
            }
            i++;
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
