package LC30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 串联所有单词的子串 {
    public static void main(String[] args) {
//        var list = new Solution().findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
        var list = new Solution().findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","good","best"});
        for(var i:list)
            System.out.println(i);
    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        var res = new ArrayList<Integer>();
        int len = s.length(), pattern = words[0].length();
        int window = pattern * words.length;
        Map<String,Integer> map = new HashMap<>();
        //O(n^2)
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        var dict = new HashMap<String,Integer>();
        //(m-n)*O[(n*n
        for(var i=0;i<=len-window;i++){
            for (String word:words){
                dict.put(word,map.get(word));
            }
            for(var j=0;j<words.length;j++){
                String cur = s.substring(i+j*pattern,i+(j+1)*pattern);
                if(dict.containsKey(cur))
                    dict.put(cur, dict.get(cur)-1);
                else
                    break;
            }
            var values = dict.values();
            boolean valid = true;
            for(int value:values){
                if(value>0)
                    valid = false;
            }
           if(valid)
               res.add(i);
        }
        return res;
    }

    /**
     * 暴力法改进。使用getOrDefault方法，简化代码
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            //可以直接用equals判断两个map中的键值对是否完全相等
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    /**
     * 滑动窗口
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        var res = new ArrayList<Integer>();
        int len = s.length(), pattern = words[0].length(),window = pattern * words.length;
        Map<String,Integer> map = new HashMap<>();
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        for(var i=0;i<pattern;i++){
            int count = 0;
            //窗口的左右边界
            int left = i, right = i;
            //n个窗口，n=单词长度
            var submap = new HashMap<String,Integer>();
            //还能滑
            while (right+pattern<s.length()){
                String word = s.substring(right,right+pattern);
                submap.put(word,submap.getOrDefault(word,0)+1);
                right+=pattern;
                //count记录了当前窗口内的单词数量
                count++;
                //出现失陪情况，移动窗口左端
                while(submap.getOrDefault(word,0)>map.getOrDefault(word,0)){
                    //扔掉窗口移动的时候丢弃的单词
                    String prev = s.substring(left,left+pattern);
                    count--;
                    submap.put(prev,submap.getOrDefault(prev,0));
                    left+=pattern;
                }
                if(count== words.length)
                    res.add(left);
            }
        }
        return res;
    }


}
