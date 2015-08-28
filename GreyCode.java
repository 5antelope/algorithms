public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(0);

        for (int i=0; i<n; i++) {
            // highest bit...
            int base = 1<<i;

            for (int j = list.size()-1; j>=0; j--) {
                // the way to generate next number:
                // add leading 1 at cur position (0 won't change anything)
                int cur = base | list.get(j);
                list.add(cur);
            }
        }

        return list;
    }
}
