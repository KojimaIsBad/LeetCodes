import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length;a++){
            //跳过重复的数
            if(a>0&&nums[a]==nums[a-1])
                continue;
            int c = nums.length-1;
            int target = -nums[a];
            for(int b=a+1;b<nums.length;b++){
                //需要和上个数不同
                if(b>a+1&&nums[b]==nums[b-1])
                    continue;
                while (b<c&&nums[b]+nums[c]>target)
                    c--;
                if(b==c)
                    break;
                if(nums[b]+nums[c]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
