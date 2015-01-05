public class RandomSelection {
    private static int index;
    public static void rSelection(int[] arr, int l, int r, int i) {
        while ((index=partition(arr, l, r))!=i) {
            if (index > i)
                rSelection(arr, l, index-1, i);
            else {
                rSelection(arr, index+1, r, i-index);
            }
        }
    }
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        while (l<r) {
            while (l<r && arr[r]>pivot)
                r--;
            arr[l] = arr[r];
            while (l<r && arr[l]<pivot)
                l++;
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rSelection(arr, 0, arr.length-1, 3);
        System.out.println(index);
    }
}
