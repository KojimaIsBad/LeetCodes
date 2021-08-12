import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//public class Main {
//    public static void main(String[] args) {
//        Solution01 tool = new Solution01();
//        int[] defset = new int[]{3, 2, 4};
//        int[] x = tool.twoSum(defset, 6);
//        System.out.println(x[0]);
//        System.out.println(x[1]);
//    }
//}

class Solution01 {
    // 1 2 3 4 5 7
    // 5 2 5 3
    // 0 1 2 3
    // 2 3 5 5
    // 1 3 0 1
    public int[] twoSum01(int[] nums, int target) {
        //这里需要保留原来的索引
        int[] origin = new int[nums.length];
        System.arraycopy(nums,0,origin,0,nums.length);
        Arrays.sort(nums);
        for (int i:origin
             ) {
            System.out.println(i);
        }
        int front = 0, tail = nums.length - 1;
        int ans1 = -1, ans2 = 0;
        while(front<tail){
            int res[] = new int[2];
            if(nums[front]+nums[tail]==target){
                ans1 = nums[front];
                ans2 = nums[tail];
            }
            if(nums[front]+nums[tail]<target)
                front++;
            else
                tail--;
        }
        return null;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                return new int[]{i, map.get(target-nums[i])};
            map.put(nums[i],i);
        }
        return null;
    }
}
