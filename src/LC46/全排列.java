package LC46;

import java.util.*;

public class 全排列 {
    public static void main(String[] args) {
        var xx = new Solution().permute2(new int[]{1, 2, 3});
        System.out.println(xx);
    }
}

class Solution {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> available = new ArrayList<>();
        for(int num:nums)
            available.add(num);
        boolean[] valid = new boolean[nums.length];
        for (var i = 0; i < nums.length; i++)
            valid[i] = true;
        exec1(nums, 0, res, new ArrayList<Integer>(),available);
        return res;
    }

    public void exec1(int[] nums, int count, List<List<Integer>> res, List<Integer> list,List<Integer> available) {
        System.out.println(count);
        if (count == nums.length)
            res.add(new ArrayList<>(list));
        for (var i = 0; i < nums.length; i++) {
            if(available.contains(nums[i])){
                list.add(nums[i]);
                available.remove(available.get(available.indexOf(nums[i])));
                count++;
                exec1(nums, count, res, new ArrayList<>(list),new ArrayList<>(available));
                count--;
                available.add(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Boolean> map = new HashMap<>();
        for(int num:nums)
            map.put(num,true);
        exec2(nums,0,0,res,new ArrayList<>(),map,new ArrayList<>());
        return res;
    }

    public void exec2(int[] nums,int index,int count,List<List<Integer>> res, List<Integer> list,Map<Integer,Boolean> map,List<Integer> last){
        if(index>=nums.length||index<0)
            return;
        if(count==nums.length&&!last.equals(list)){
            last = list;
            res.add(new ArrayList<>(list));
            return;
        }

        //不用当前数
        exec2(nums,index+1,count,res,new ArrayList<>(list),new HashMap<>(map),last);

        if(map.get(nums[index])){
            //用当前数
            list.add(nums[index]);
            map.put(nums[index],false);
            exec2(nums,index+1,count+1,res,new ArrayList<>(list),new HashMap<>(map),last);
            map.put(nums[index],true);
            list.remove(list.size()-1);

            list.add(nums[index]);
            map.put(nums[index],false);
            exec2(nums,index-1,count+1,res,new ArrayList<>(list),new HashMap<>(map),last);
            map.put(nums[index],true);
            list.remove(list.size()-1);
        }

        exec2(nums,index-1,count,res,new ArrayList<>(list),new HashMap<>(map),last);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}