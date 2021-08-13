package LC27;

public class 移除元素 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{3,2,2,3},3));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int next = 0, scan = 0;
        while (scan<nums.length){
            if(nums[scan]!=val){
                nums[next] = nums[scan];
                next++;
            }
            scan++;
        }
        return next;
    }
}