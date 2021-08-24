package LC39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 组合总合 {
}

class Solution {
    //法1 龟速dfs------------------------------------------------------------------------------------------------
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
//        for(int i=0;i<candidates.length;i++){
//            dfs(candidates,i,target,res,new ArrayList<Integer>());
//        }
//        return res;
//    }
//
//    private void dfs(int[] candidates,int num,int limit,List<List<Integer>> lists,List<Integer> list){
//        list.add(candidates[num]);
//        if(candidates[num]>limit)
//            return;
//        if(candidates[num]==limit){
//            Collections.sort(list);
//            if(!lists.contains(list))
//                lists.add(list);
//        }else {
//            for(int i=0;i<candidates.length;i++)
//                dfs(candidates,i,limit-candidates[num],lists,new ArrayList<>(list));
//        }
//    }
    //法2-------------------------------------------------------------------------

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs2(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs2(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        //当前考虑的元素的索引
        if (idx == candidates.length) {
            return;
        }
        //完成目标
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 考虑下一个数
        dfs2(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs2(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    //--------------------------------------------------------
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs3(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void dfs3(int[] candidates, int no, int target, List<List<Integer>> res, List<Integer> path) {
        if (no == candidates.length || target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        //两种选择，考虑下一个数，或是继续使用当前数

        //使用下一个数
        dfs3(candidates, no + 1, target, res, path);

        //使用当前数
        if (target - candidates[no] >= 0) {
            path.add(candidates[no]);
            dfs3(candidates, no, target - candidates[no], res, path);
            path.remove(path.size() - 1);
        }

    }


}