public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n<2)    return 0;
        int area = 0;
        int l=0, r=n-1;
        while (l<r) {
            if (height[l]<height[r]) {
                // left limits area, cp cur. max and move limitation (l) for better solution
                area = Math.max(area, height[l]*(r-l));
                l++;
            }
            else {
                area = Math.max(area, height[r]*(r-l));
                r--;
            }
        }
        return area;
    }
}
