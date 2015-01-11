public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<size; i++) {
            int dif = target - numbers[i];
            if (map.containsKey(dif)) {
                int idx1 = map.get(dif);
                int idx2 = i+1;
                int[] res = {idx1, idx2};
                return res;
            }
            map.put(numbers[i],i+1);
        }
        return null
    }
}
