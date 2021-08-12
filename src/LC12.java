import java.util.HashMap;
import java.util.Map;

public class LC12 {
}

//M -> D ->C -> L ->X -> V -> I
class Solution12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        //确定M
        int M = num / 1000;
        num -= 1000 * M;
        for(int i=0;i<M;i++) sb.append('M');

        int C = num / 100;
        switch (C){
            case 5:
                sb.append('D');
                break;
            case 4:
                sb.append("CD");
                break;
            case 9:
                sb.append("CM");
                break;
            case 6,7,8:
                sb.append('D');
                for(int i=0;i<C-5;i++) sb.append('C');
                break;
            case 1,2,3:
                for(int i=0;i<C;i++) sb.append('C');
                break;
        }
        num -= 100 * C;
        int X = num / 10;
        switch (X){
            case 5:
                sb.append('L');
                break;
            case 4:
                sb.append("XL");
                break;
            case 9:
                sb.append("XC");
                break;
            case 6,7,8:
                sb.append('L');
                for(int i=0;i<X-5;i++) sb.append('X');
                break;
            case 1,2,3:
                for(int i=0;i<X;i++) sb.append('X');
                break;
        }
        num -= 10 * X;
        int I = num;
        switch (I){
            case 5:
                sb.append('V');
                break;
            case 4:
                sb.append("IV");
                break;
            case 9:
                sb.append("IX");
                break;
            case 6,7,8:
                sb.append('V');
                for(int i=0;i<I-5;i++) sb.append('I');
                break;
            case 1,2,3:
                for(int i=0;i<I;i++) sb.append('I');
                break;
        }
        return sb.toString();
    }

    public int romanToInt(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        int firstC = -1;
        int firstI = -1;
        int firstX = -1;
        for(int i=0;i<cs.length;i++){
            if(firstI==-1&&cs[i]=='I')
                firstI = i;
            if(firstX==-1&&cs[i]=='X')
                firstX = i;
            if(firstC==-1&&cs[i]=='C')
                firstC = i;
        }

        for(int i=0;i<cs.length;i++){
            switch (cs[i]){
                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'C':
                    if(isPost(cs[i],cs,i))
                        res+=100;
                    else
                        res-=100;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'X':
                    if(isPost(cs[i],cs,i))
                        res+=10;
                    else
                        res-=10;
                    break;
                case 'V':
                    res+=5;
                    break;
                case 'I':
                    if(isPost(cs[i],cs,i))
                        res+=1;
                    else
                        res-=1;
                    break;
            }
        }

        return res;
    }

    private boolean isPost(char c,char[] cs,int start){
        if(c=='C'){
            for(int i=start;i<cs.length;i++)
                if(cs[i]=='M'||cs[i]=='D')
                    return false;
            return true;
        }
        if(c=='I'){
            for(int i=start;i<cs.length;i++)
                if(cs[i]=='V'||cs[i]=='X')
                    return false;
            return true;
        }
        if(c=='X'){
            for(int i=start;i<cs.length;i++)
                if(cs[i]=='L'||cs[i]=='C')
                    return false;
            return true;
        }
        return false;
    }
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int RomanToInt(String s){
        int res = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        for(int i=0;i<len;i++){
            int val = symbolValues.get(cs[i]);
            if(i<len-1&&val<symbolValues.get(cs[i+1]))
                res-=val;
            else
                res+=val;
        }
        return res;


    }


}