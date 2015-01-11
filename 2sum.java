public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        Arrays.sort(numbers); // Arrays.sort returns void!
        int left = 0, right = size-1;
        while (left<right) {
            if (sortedArray[left]+sortedArray[right] > target)
                right--;
            else if (sortedArray[left]+sortedArray[right] < target) 
                left++;
            else {
                int[] idx = {left+1, right+1};
                return idx;
            } 
        }
        return null
    }
}
