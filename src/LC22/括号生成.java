package LC22;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();
        backTrace(new StringBuffer(),0,res,n,0,0);
        return res;
    }

    private void backTrace(StringBuffer sb,int num,List<String> set,int limit,int cl,int cr){
        if(cl<cr)
            return;
        if(num==2*limit){
            set.add(sb.toString());
            return;
        }
        if(cl<limit){
            sb.append('(');
            backTrace(sb,num+1,set,limit,cl+1,cr);
            sb.deleteCharAt(num);
        }
        if(cr<limit){
            sb.append(')');
            backTrace(sb,num+1,set,limit,cl,cr+1);
            sb.deleteCharAt(num);
        }
    }

    private boolean isLegal(String str){
        int leftCount = 0, rightCount = 0;
        for(var i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                leftCount++;
            else
                rightCount++;
            if(rightCount>leftCount)
                return false;
        }
        return true;
    }
}