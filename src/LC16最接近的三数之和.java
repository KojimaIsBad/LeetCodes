import java.util.Arrays;

public class LC16最接近的三数之和 {

    public static int threeSumClosest(int[] nums, int target) {
        int res = 0, sum = nums.length;
        int offset = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int a=0;a<sum;a++){
            int b = a+1;
            int c = sum - 1;
            while(b<c){
                int curSum = nums[a]+nums[b]+nums[c];
                if(Math.abs(curSum-target)<=offset){
                    offset = Math.abs(curSum-target);
                    res = curSum;
                }
                if(curSum>target)
                    c--;
                else if (curSum<target)
                    b++;
                else
                    return curSum;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,-1},2));
    }
}
