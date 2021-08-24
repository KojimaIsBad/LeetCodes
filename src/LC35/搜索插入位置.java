package LC35;

public class 搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert0(new int[]{1,3,5,6},8));
    }
}


class Solution {
    /**
     * 初始解法 ，有错误
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert0(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int spot = nums.length;
        while (left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid]>=target){
                spot = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return spot;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //默认在最后一位插入
        int spot = nums.length;
        //寻找比他大的第一个元素
        while (left <= right) {
            int mid = (right + left) / 2;
            if(target<=nums[mid]){
                spot = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return spot;
    }
}