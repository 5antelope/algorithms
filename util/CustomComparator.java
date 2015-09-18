/**
 * a few notes:
 * implements instead of extends Comparator!
 * the method to implement is:
 *    int compare(Obejct a, Object b)
 * 
 * ascending order: return a-b
 * descending order: return b-a
 */
class MyComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return x-y;
    }
}
