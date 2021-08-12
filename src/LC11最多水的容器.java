public class LC11最多水的容器 {

}

class Solution11 {
    public int maxArea01(int[] height) {
        int sum = height.length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < sum; i++) {
            for (int j = i + 1; j < sum; j++)
                if (height[j] * (j - i) > maxArea)
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int sum = height.length, maxArea = Integer.MIN_VALUE;
        if (sum <= 1)
            return 0;
        int left = 0, right = sum - 1;
        while (left<right){
            if(height[left]<height[right]){
                maxArea = Math.max(height[left] * (right-left),maxArea);
                left++;
            }else {
                maxArea = Math.max(height[right] * (right-left),maxArea);
                right--;
            }

        }
        return maxArea;
    }



}