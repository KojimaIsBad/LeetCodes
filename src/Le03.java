import java.util.HashMap;

public class Le03 {
//    public static void main(String[] args) {
//        System.out.println(new Solution03().lengthOfLongestSubstring("pwwkew"));
//    }
}
// 最长无重复子串

class Solution03 {
    /**
     * 错误解法，误解了无重复的意思，理解成没有连续重复字符
     *
     * @param s
     * @return
     */
    public int Wrong01lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        //前后两个指针
        int p1 = 0, p2 = 1;
        //当前最大长度
        int max = 0;
        //当前测量起点的索引
        int base = 0;

        while (p2 < s.length()) {
            if (s.charAt(p1) == s.charAt(p2)) {
                max = (p1 - base + 1 > max) ? p1 - base + 1 : max;
                base = p1 = p2;
                p2++;
            } else {
                p2++;
                p1++;
            }
        }
        max = (p1 - base + 1 > max) ? p1 - base + 1 : max;
        return max;
    }

    public int AC01lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int base = 0;
        int max = 0;
        int p = 0;
        HashMap<Character, Integer> map;
        while (base < s.length() && p < s.length()) {
            map = new HashMap<>();
            while (p < s.length()) {
                if (map.containsKey(s.charAt(p))) {
                    max = (p - base > max) ? p - base : max;
                    base++;
                    p = base;
                    break;
                } else {
                    map.put(s.charAt(p), 1);
                    p++;
                    max = (p - base > max) ? p - base : max;
                }
            }

        }
        return max;
    }

    /**
     * 滑动窗口，避免了右指针的回溯
     * @param s
     * @return
     */
    public int AC02lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int base = 0;
        int max = 0;
        int p = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (base < s.length() && p < s.length()) {
            while (p < s.length()) {
                if (map.containsKey(s.charAt(p))) {
                    max = (p - base > max) ? p - base : max;
                    map.remove(s.charAt(base));
                    base++;
                    break;
                } else {
                    map.put(s.charAt(p), 1);
                    p++;
                    max = (p - base > max) ? p - base : max;
                }
            }
            if(p==s.length())
                return max;
        }
        return max;
    }

    /**
     * 优化了代码结构
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        int base = 0;
        int max = 0;
        int p = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (base < s.length() && p < s.length()) {
            while (p < s.length() && !map.containsKey(s.charAt(p))) {
                map.put(s.charAt(p), 1);
                p++;
            }
            max = (p - base > max) ? p - base : max;
            if (p == s.length())
                return max;
            else {
                map.remove(s.charAt(base));
                base++;
            }
        }
        return max;
    }
}