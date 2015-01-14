public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n<2)    return 0;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int h = Math.min(height[i],height[j]);
                max = Math.max(max, h*(j-1));
            }
        }
        return max;
    }
}
