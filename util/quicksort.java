import java.util.*;

public class QuickSort {
  public QuickSort(int[] array) {
    QSort(array,0,array.length-1);
  }
  
  private void QSort(int[] array, int l, int r) {
    while(l<r) {
      int pivot = partition(array, l, r);
      QSort(array, l, pivot-1);
      // does not recursively call QSort, for stack sake
      l = pivot+1;
    }
  }
  
  private int partition(int[] array, int l, int r) {
    int pivot = array[l];
    while (l<r) {
      // order matters
      while(l<r && array[r]>=pivot)
        r--;
      // just replace, no need for swap  
      array[r] = array[l];
      while(l<r && array[l]<=pivot)
        l++;
      array[r] = array[l];
    }
    array[l] = pivot;
    return l;
  }
}
