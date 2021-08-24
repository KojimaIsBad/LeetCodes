package LC40;

import LC23.合并K个升序链表;

import java.util.*;

public class 组合综合2 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = new Solution().combinationSum21(candidates, target);
        for (List<Integer> list : res) {
            System.out.print("[ ");
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print(" ]");
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
//        if (Arrays.stream(candidates).sum() < target)
//            return res;
        dfs(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }


    //重点：Candodates中的每个数字只能使用一次
    private void dfs(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (var i = index; i < candidates.length; i++) {
            if(target-candidates[i]<0)
                break;
            //排除同一层相同的节点
            if(i>index&&candidates[i]==candidates[i-1])
                continue;
            list.add(candidates[i]);
            dfs(candidates,i+1,target-candidates[i], new ArrayList<>(list),res);
            list.remove(list.size()-1);
        }

    }

//    private void dfs2(int[] candidates, boolean[] valid, int index, int target, List<Integer> list, List<List<Integer>> res) {
//
//        if (index == candidates.length)
//            return;
//        if (target == 0) {
//            Collections.sort(list);
//            if (!res.contains(list))
//                res.add(list);
//            return;
//        }
//        dfs2(candidates, valid, index + 1, target, list, res);
//
//        if (valid[index] && target - candidates[index] >= 0) {
//            valid[index] = false;
//            list.add(candidates[index]);
//            dfs2(candidates, valid, index + 1, target - candidates[index], new ArrayList<>(list), res);
//            list.remove(list.size() - 1);
//            valid[index] = true;
//        }
//    }

    /**
     * 改进1 使用HashMap统计每个数字的出现频率
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        var map = new HashMap<Integer, Integer>();
        if (Arrays.stream(candidates).sum() < target)
            return res;
        for (int num : candidates) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        int[] test = Arrays.stream(keys).mapToInt(Integer::intValue).toArray();
        dfs3(map, 0, target, list, res, test, new ArrayList<>());
        return res;
    }

    private void dfs3(Map<Integer, Integer> map, int index, int target, List<Integer> list, List<List<Integer>> res, int[] keys, List<Integer> prev) {
        if (index == keys.length)
            return;
        if (target == 0) {
            if (!list.equals(prev)) {
                res.add(new ArrayList<>(list));
                prev = list;
            }
        }
        //两种选择：用下一位，或者用这一位
        //[1]用下一位
        dfs3(map, index + 1, target, list, res, keys, prev);

        if (map.get(keys[index]) > 0 && target - keys[index] >= 0) {
            map.put(keys[index], map.get(keys[index]) - 1);
            list.add(keys[index]);
            dfs3(map, index, target - keys[index], new ArrayList<>(list), res, keys, prev);
            list.remove(list.size() - 1);
            map.put(keys[index], map.get(keys[index]) + 1);
        }
    }

//    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(candidates);
//        var map = new HashMap<Integer, Integer>();
//        if (Arrays.stream(candidates).sum() < target)
//            return res;
//        for (int num : candidates) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        Integer[] keys = map.keySet().toArray(new Integer[0]);
//        int[] test = Arrays.stream(keys).mapToInt(Integer::intValue).toArray();
//        dfs3(map, 0, target, list, res, test,new ArrayList<>());
//        return res;
//    }
//
//    private void dfs3(Map<Integer, Integer> map, int index, int target, List<Integer> list, List<List<Integer>> res, int[] keys,List<Integer> prev) {
//        if (index == keys.length)
//            return;
//        if (target == 0) {
//            if(!list.equals(prev)){
//                res.add(new ArrayList<>(list));
//                prev = list;
//            }
//        }
//        //两种选择：用下一位，或者用这一位
//        //[1]用下一位
//        dfs3(map, index + 1, target, list, res, keys,prev);
//
//        if (map.get(keys[index]) > 0 && target - keys[index] >= 0) {
//            map.put(keys[index], map.get(keys[index]) - 1);
//            list.add(keys[index]);
//            dfs3(map, index, target - keys[index], new ArrayList<>(list), res,keys,prev);
//            list.remove(list.size() - 1);
//            map.put(keys[index], map.get(keys[index]) + 1);
//        }
//    }

}