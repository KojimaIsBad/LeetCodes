package LC49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 字符串聚类 {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var res = new ArrayList<List<String>>();
        if (strs.length == 0)
            res.add(new ArrayList<>());
        var map = new HashMap<Integer, List<String>>();
        for (var i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            int sum = 0;
            for (char c : cs)
                sum += c;
            if (map.containsKey(sum)) {
                List<String> list = map.get(sum);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sum, list);
            }
        }
        var lists = map.values();
        for (List<String> li : lists)
            res.add(li);
        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        var res = new ArrayList<List<String>>();
        if (strs.length == 0)
            res.add(new ArrayList<>());
        var map = new HashMap<String, List<String>>();
        for (var i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        var lists = map.values();
        for (List<String> li : lists)
            res.add(li);
        return res;
    }
}