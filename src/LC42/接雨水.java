package LC42;

public class 接雨水 {
    public static void main(String[] args) {
//        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(new Solution().trap(new int[]{4,2,0,3,2,5}));
        System.out.println(new Solution().trap(new int[]{8,5,4,1,8,9,3,0,0}));
    }
}

class Solution {
    /**
     * 双指针，需要回溯右指针
     * 空间O(1),时间O(n2)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int left = 0, right = 1;
        int water = 0;
        while (right < height.length && left < height.length) {
            if (height[left] == 0) {
                left++;
                right = left + 1;
            }
            while (right < height.length && height[left] > height[right]) {
                right++;
            }
            if (right < height.length) {
                //此时，h[l]<=h[r]，可以计算容积
                int S1 = height[left] * (right - left - 1);
                for (var i = left + 1; i < right; i++)
                    S1 -= height[i];
                water += S1;
            } else {
                //没找到
                right = findMax(height, left + 1);
                //右侧不存在档雨水的挡板
                if (right == height.length)
                    break;
                int S1 = height[right] * (right - left - 1);
                for (var i = left + 1; i < right; i++)
                    S1 -= height[i];
                water += S1;
            }
            left = right;
            right++;
//            System.out.println(water);
        }
        return water;
    }

    private int findMax(int[] height, int start) {
        int maxIndex = start;
        for (var i = start; i < height.length; i++) {
            if (height[i] > height[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    /**
     * 双指针 避免回溯O(n)&O(1)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //水不会从右边漏出来
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            }
            //水不会从左边漏出来
            else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}