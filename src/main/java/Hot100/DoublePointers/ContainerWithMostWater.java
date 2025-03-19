package Hot100.DoublePointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            int high = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, high * width);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
