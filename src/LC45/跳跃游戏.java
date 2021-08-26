package LC45;

public class 跳跃游戏 {
    public static void main(String[] args) {
        var t1 = System.currentTimeMillis();
//        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9,
                0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};
//        System.out.println(nums.length);
        System.out.println(new Solution().jump(nums));
        System.out.print("Times: ");
        System.out.println(System.currentTimeMillis() - t1);
    }
}

class Solution {
    int flag = Integer.MAX_VALUE;

    /**
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] f = new int[nums.length];
        for (var i = 0; i < f.length; i++)
            f[i] = i;
        f[0] = 0;
        for (var i = 0; i < nums.length - 1; i++) {
            for (var dist = 1; dist <= nums[i]; dist++) {
                int end = (i + dist < nums.length) ? i + dist : nums.length - 1;
                f[end] = Math.min(f[end], f[i] + 1);
                if(i+dist>=nums.length-1)
                    break;
            }
        }
        return f[nums.length - 1];
    }

    /**
     * 从后向前 贪心
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 从前向后 贪心，每次记录能够到达的最远距离 迪杰斯特拉算法思想
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int length = nums.length;
        //当前边界
        int end = 0;
        //可到达的最大边界
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //到达边界，进行跳跃
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 递归。结果正确，超时
     * @param nums
     * @param pos
     * @param step
     * @return
     */
    public int move(int[] nums, int pos, int step) {

        //到达目的地
        int dist = nums.length - 1 - pos;
        if (dist == 0) {
            flag = Math.min(step, flag);
            return step;
        }
        //够得到
        if (dist <= nums[pos]) {
            flag = Math.min(step + 1, flag);
            return step + 1;
        }

        //跳不了
        if (nums[pos] == 0 || step >= flag) {
            return nums.length + 1;
        }
        int val = nums.length + 2;
        for (var i = 1; i <= nums[pos]; i++) {
            if (nums[pos + i] != 0) {
                int temp = move(nums, pos + i, step + 1);
                val = Math.min(temp, val);
            }
        }
        return val;
    }
}