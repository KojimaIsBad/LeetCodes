package LC33;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int search0(int[] nums, int target) {
        for(var i=0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if(nums[0]<target){
            for(var i=nums.length-1;i>=0;i--){
                if(nums[i]==target)
                    return i;
            }
        }
        else {
            for(var i=0;i<nums.length;i++){
                if(nums[i]==target)
                    return i;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //是有序数组
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //不是有序数组
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}