import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
//    public static void main(String[] args) {
//        int[] nums = new int[]{1,0,-1,0,-2,2};
//        System.out.println(new Solution18().fourSum(nums,0));
//    }
}

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int a = 0; a < sum-3; a++) {
            if(a>0&&nums[a-1]==nums[a])
                continue;
            if(nums[a]+nums[a+1]+nums[a+2]+nums[a+3]>target)
                break;
            //转换为三数之和
            int newTarget = target - nums[a];
            for(int b=a+1;b<sum;b++){
                if(b>a+1&&nums[b]==nums[b-1])
                    continue;
                if(nums[b]+nums[b+1]+nums[b+2]>target-nums[a])
                    break;
                int curTarget = newTarget - nums[b];
                int d = sum - 1;
                for(int c = b+1;c<sum;c++){
                    if(c>b+1&&nums[c]==nums[c-1])
                        continue;
                    while (c<d&&nums[c]+nums[d]>curTarget){
                        d--;
                    }
                    if(c==d)
                        break;
                    if(nums[c]+nums[d]==curTarget){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
}
