public class Solution {
    /**
     * the basic idea is seperate into two sets: one for elem before, one for after
     * this takes O(n) space..
     *
     * to use O(1) space, use kinda DP..
     */
    public int[] productExceptSelf(int[] nums) {

        int res[] = new int[nums.length];

        int unit = 1;

        // to get production of every elements before
        for (int i=0; i<nums.length; i++) {
            res[i] = unit;
            unit *= nums[i];
        }

        unit = 1;

        // to get production of every elements after
        for (int i=nums.length-1; i>=0; i--) {
            res[i] *= unit;
            unit *= nums[i];
        }

        return res;
    }
}
