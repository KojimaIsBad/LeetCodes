import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_回溯法联系 {
}

class SolutionSB {
    public List<String> letterCombinations(String digits) {
        var res = new ArrayList<String>();
        Map<Character,String> digitMap = new HashMap<>();
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");
        backTrace(new StringBuilder(),digits,0,res,digitMap);
        return res;
    }

    private void backTrace(StringBuilder cur,String digits,int index,List<String> res,Map<Character,String> map){
        if(index==digits.length()){
            res.add(cur.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for(int i=0;i<letters.length();i++){
            cur.append(letters.charAt(i));
            backTrace(cur,digits,index+1,res,map);
            cur.deleteCharAt(index);
        }
    }
}