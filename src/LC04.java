import java.util.Arrays;

public class LC04 {
//    public static void main(String[] args) {
////        System.out.println(new Solution04().findMedianSortedArrays(new int[]{2,2,2,2}, new int[]{2,2,2}));
//        double x = 5.5;
//        System.out.println(x%1);
//        System.out.println(x%0.5==0);
//    }
}


class Solution04 {
    public double AC01findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, all, 0, nums1.length);
        System.arraycopy(nums2, 0, all, nums1.length, nums2.length);
        Arrays.sort(all);
        if (all.length % 2 != 0)
            return all[all.length / 2];
        else
            return 0.5 * (all[all.length / 2 - 1] + all[all.length / 2]);
    }

    public double AC02findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
//        int lp = (nums1.length==0)? 1:0, rp =(nums2.length==0)?1: 0;
        int lp =0,rp = 0;
        //情况1，总数是偶数，此时需要找第L/2大的数和第L/2小的数
        if(len%2==0){
            int count = 0, val1 = 0, val2 = Integer.MAX_VALUE;
            while (count<len/2){
                if(lp<nums1.length&&(nums2.length==0||rp==nums2.length||nums1[lp]<nums2[rp])){
                    val1 = nums1[lp];
                    lp++;
                }
                else {
                    val1 = nums2[rp];
                    rp++;
                }
                count++;
            };
            val2 = (lp<nums1.length&&nums1[lp]<=val2)?nums1[lp]:val2;
            val2 = (rp<nums2.length&&nums2[rp]<=val2)?nums2[rp]:val2;
            return 0.5 * (val1 + val2);
        } else{
            int count = 0, val = Integer.MAX_VALUE;
            while (count<len/2+1){
                if(lp<nums1.length&&(nums2.length==0||rp==nums2.length||nums1[lp]<nums2[rp])){
                    val = nums1[lp];
                    lp++;
                }
                else {
                    val = nums2[rp];
                    rp++;
                }
                count++;
            }
            return val;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if(l1==0)
            return findMedianSortedArrays(nums2,nums2);
        else if(l2==0)
            return findMedianSortedArrays(nums1,nums1);

        int lp =0,rp = 0, len = l1+l2;

        //情况1，总数是偶数，此时需要找第L/2大的数和第L/2小的数
        if(len%2==0){
            int count = 0, val1 = 0, val2 = Integer.MAX_VALUE;
            while (count<len/2){
                if(lp<nums1.length&&(rp==nums2.length||nums1[lp]<nums2[rp])){
                    val1 = nums1[lp];
                    lp++;
                }
                else {
                    val1 = nums2[rp];
                    rp++;
                }
                count++;
            };
            val2 = (lp<nums1.length&&nums1[lp]<=val2)?nums1[lp]:val2;
            val2 = (rp<nums2.length&&nums2[rp]<=val2)?nums2[rp]:val2;
            return 0.5 * (val1 + val2);
        } else{
            int count = 0, val = Integer.MAX_VALUE;
            while (count<len/2+1){
                if(lp<nums1.length&&(rp==nums2.length||nums1[lp]<nums2[rp])){
                    val = nums1[lp];
                    lp++;
                }
                else {
                    val = nums2[rp];
                    rp++;
                }
                count++;
            }
            return val;
        }
    }
}