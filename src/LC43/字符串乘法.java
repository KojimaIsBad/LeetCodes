package LC43;

public class 字符串乘法 {
    public static void main(String[] args) {
//        System.out.println(new Solution().singleMul("123",'2'));
        System.out.println(new Solution().multiply("408","5"));
    }


}

class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0)
            return l1 == 0 ? num2 : num1;
        StringBuilder ans = new StringBuilder();
        for(var i=0;i<num2.length();i++){
            char dig = num2.charAt(l2-1-i);
            StringBuilder val = singleMul(num1,dig);
            for(var j=0;j<i;j++)
                val = val.append(0);
            ans = add(ans.toString(),val.toString());

        }
        int first = 0;
        while (first<ans.length()&&ans.charAt(first)=='0')
            first++;
        if(first==ans.length())
            return "0";
        return ans.substring(first).toString();
    }

    public StringBuilder singleMul(String nums, char num) {
        int dig0 = num - '0';
        int move = 0;
        StringBuilder sb = new StringBuilder();
        for (var i = nums.length() - 1; i >= 0; i--) {
            int dig1 = nums.charAt(i)-'0';
            int sum = dig0 * dig1 + move;
            move = sum / 10;
            int val = sum % 10;
            sb.append(val);
        }
        if(move>0)
            sb.append(move);
//        while (sb.charAt(sb.length()-1)=='0')
//            sb.deleteCharAt(sb.length()-1);
        return sb.reverse();
    }

    public StringBuilder add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0)
            return l1 == 0 ? new StringBuilder(num2) : new StringBuilder(num1);
        l1--;
        l2--;
        int move = 0;
        while (l1 >= 0 || l2 >= 0) {
            int dig1 = (l1 >= 0) ? num1.charAt(l1) - '0' : 0;
            int dig2 = (l2 >= 0) ? num2.charAt(l2) - '0' : 0;
            int sum = dig1 + dig2 + move;
            int val = sum % 10;
            move = (sum >= 10) ? 1 : 0;
            sb.append(val);
            l1--;
            l2--;
        }
        if(move>0)
            sb.append(move);
        return sb.reverse();
    }
}