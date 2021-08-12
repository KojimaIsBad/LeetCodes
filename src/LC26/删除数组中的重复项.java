package LC26;

public class 删除数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}

class Solution {
    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int lp = 0, rp = 1, len = nums.length;
        while(lp<len&&rp<len){
            if(nums[lp]==nums[rp]){
                for(int i=lp;i<nums.length-1;i++){
                    nums[i] = nums[i+1];
                }
                --len;
            }else {
                lp++;
                rp++;
            }
        }
        return len;
    }

    public int removeDuplicatesGood(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int lp = 0, rp = 1, len = nums.length;
        while (lp<len){
            if(nums[rp]==nums[lp]){
                --len;
                rp++;
            }else {
                lp = rp;
                rp++;
            }
        }
        return len;
    }
}