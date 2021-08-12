public class LC06 {
//    public static void main(String[] args) {
//        System.out.println(new Solution06().convert2("ABCDE",2));
//
//    }
}
class Solution06 {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int R = numRows;
        int L0 = ((s.length()-1) % (2*R-2)<R)?0:(s.length()-1) % (2*R-2)-R+1;
        int L = (R - 1) * s.length() / (2* R - 2)+L0+1;
        if(L==0)
            return s;
        char[][] M = new char[R][L];
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            int count = i % (2*R-2);
            int x = count < R ? count : 2 * R - count - 2;
            int y0 = count < R ? 0 : count - R + 1;
            int y1 = (R-1)* (i/(2*R-2)) ;
            int y = y0 + y1;
            M[x][y] = cs[i];
        }
        String res = "";
        for(int x=0;x<R;x++)
            for(int y=0;y<L;y++)
                if(M[x][y]!=0)
                    res += Character.toString(M[x][y]);
        return res;
    }
    public String convert2(String s, int numRows) {
        if(numRows==1)
            return s;
        int R = numRows;
        String ss[] = new String[R];
        for(int i=0;i<R;i++)
            ss[i] = "";
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            int count = i % (2*R-2);
            int x = count < R ? count : 2 * R - count - 2;
            ss[x] += Character.toString(cs[i]);
        }
        String res = "";
        for(int i=0;i<R;i++)
            res+=ss[i];
        return res;
    }
    public String convert3(String s, int numRows) {
        if(numRows==1)
            return s;
        int R = numRows;
        StringBuilder ss[] = new StringBuilder[R];
        for(int i=0;i<R;i++)
            ss[i] = new StringBuilder();
        char[] cs = s.toCharArray();
        for(int i=0;i<cs.length;i++){
            int count = i % (2*R-2);
            int x = count < R ? count : 2 * R - count - 2;
            ss[x] .append(cs[i]);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<R;i++)
            res.append(ss[i]);
        return res.toString();
    }


}