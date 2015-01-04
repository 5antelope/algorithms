public class Solution {
	public static int subroutine(int[] arr, int l, int r) {
        if (l == r-1)
            return 0;
        int m = (l+r)/2;
        int a = subroutine(arr,l,m);
        int b = subroutine(arr,m,r);
        int c = merge(arr,l,m,r);
        return a+b+c;
    }
    public static int merge(int[] a, int l, int m, int r) {
        int c = 0, p1 = l, p2 = m;
        int[] buf = new int[r-l];
        for (int i=0; i<r-l; i++) {
            if (p2>=r || p1<m && a[p1]<=a[p2])
                buf[i] = a[p1++];
            else {
                c += (m - p1);
                buf[i] = a[p2++];
            }
        }
        for (int i = 0; i< r-l; i++) {
            a[l+i] = buf[i];
        }
        return c;
    }
    public static void main (String[] args) {
        int[] array = {1,2,5,4,3};
        int count = subroutine(array, 0, array.length);
        System.out.println(count);
    }
}
