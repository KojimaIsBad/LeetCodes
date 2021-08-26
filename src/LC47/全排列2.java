package LC47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {
    public static void main(String[] args) {
        System.out.println(new Solution().permute1(new int[]{1, 1, 2}));
    }
}

class Solution {
    boolean[] avail;

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        avail = new boolean[nums.length];
        for (var i = 0; i < nums.length; i++)
            avail[i] = true;
        exec1(nums, 0, res, new ArrayList<>(), avail);
        return res;
    }

    public void exec1(int[] nums, int count, List<List<Integer>> res, List<Integer> list, boolean[] avail) {
        if (count == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (var i = 0; i < nums.length; i++) {
            //在同一层上一个数有被使用，且这个数和上一个数相同时才进行排除。
            if (i > 0 && nums[i] == nums[i - 1] && avail[i-1])    //不能忽略avail[i-1]
                continue;
            if (avail[i]) {
                list.add(nums[i]);
                avail[i] = false;
                exec1(nums, count + 1, res, list, avail);
                avail[i] = true;
                list.remove(list.size() - 1);
            }
        }
    }

//    public void exec2(int[] nums, int index, List<List<Integer>> res, List<Integer> list,int[] avail) {
//        if (index == nums.length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (var i =index; i < nums.length; i++) {
//            System.out.println("Index: "+index+"; "+"i: "+i+"; nums[i]: "+nums[i]+" "+list);
////            if((i>0&&nums[i]==nums[i-1]))
////                continue;
//            //需要排除同一层相同的情况
//            if(avail[i]==1){
//                list.add(nums[i]);
//                avail[i]=0;
//                exec2(nums, index + 1, res, new ArrayList<>(list),avail);
//                avail[i]=1;
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}