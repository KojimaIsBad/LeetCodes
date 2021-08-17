package LC31;

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,5,8,4,7,6,5,3,1};
//        int nums[] = new int[]{2,3,1,3,3};

        //i=2(p=3)
        //j=3
        //

        //i=0,j=2
        //2->3->1
        //2和3（a[1]和a[2]

        new Solution().nextPermutation2(nums);
//        Arrays.sort(nums,1,nums.length);
        for(var i:nums)
            System.out.println(i);
    }
}
class Solution {
    /**
     * 时间复杂度O(nlogn),空间O(1)
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return;
        int p = len - 1;
        while (p>0) {
            int cur = nums[p];
            int prev = nums[p - 1];
            if (prev < cur) {
                //在p之后找一个最小的数
                int min_index = p, i=p;
                while (i<nums.length){
                    if(nums[i]<nums[min_index]&&nums[i]>prev){
                        min_index = i;
                    }
                    i++;
                }
                int temp = nums[min_index];
                nums[min_index] = prev;
                nums[p-1] = temp;
                Arrays.sort(nums,p,nums.length);
                //然后对p之后的部分进行排序
                return;
            }
            p--;
        }
        Arrays.sort(nums);
    }

    //改进，避免排序
    public void nextPermutation2(int[] nums) {
        int len = nums.length;
        if(len<=1)
            return;
        int p = len - 1;
        while (p>0) {
            int cur = nums[p];
            int prev = nums[p - 1];
            //找a[i]
            if (prev < cur) {
                //找到右边比他大的最小数
                int min_index = p, i=nums.length-1;
                //找a[j],注意从a[i]的右边开始找
                while (i>p-1){
                    if(nums[i]<=nums[min_index]&&nums[i]>prev){
                        min_index = i;
                        //因为右侧一定是降序，所以只需要找到一个就可以停止
                        break;
                    }
                    i--;
                }
                //交换a[i]和a[j]
                swap(nums,min_index,p-1);
                //反转a[i+1,j]
                reverse(nums,p);
                return;
            }
            p--;
        }
        reverse(nums,0);
    }

    /**
     * time:O(n); space:O(1)
     * @param nums
     */
    public void nextPermutation1(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}