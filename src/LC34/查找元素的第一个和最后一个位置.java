package LC34;

import LC23.合并K个升序链表;

public class 查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] res = new Solution().searchRange(nums,1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};
        int[] res = new int[2];
        res[0] = res[1] = -1;
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                //找到1个
                int l = mid, r = mid;
                while (l>0&&nums[l-1]==target)
                    l--;
                while (r<nums.length-1&&nums[r+1]==target)
                    r++;
                res[0] = l;
                res[1] = r;
                break;
            }

            else if (nums[mid]>target){
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        //判断找到的数是否合法
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @param lower true表示找左边界，false表示找右边界
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            //目标在mid左边，或要找左边界且目标在mid上
            if (nums[mid] > target || (lower && nums[mid] >= target)) {     //往左边搜索
                right = mid - 1;
                ans = mid;
            } else {                                                        //往右侧搜索
                left = mid + 1;
            }
        }
        return ans;
    }
}