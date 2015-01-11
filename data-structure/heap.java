import java.util.Arrays;

public class Heap {
    // array implementation minHeap
    private static final int CAPACITY = 8;
    private int size;
    private Integer[] heap;
    public Heap() {
        size = 0; // size: how many obj. ALREADY in tree
        heap = new Integer[CAPACITY+1];
    }
    public Heap(int[] array) {
        size = 0;
        heap = new Integer[array.length+1];   // heap index start from 1, not 0
        for (int i:array)
            add(i);
    }
    public void add (int num) {
        if (size == heap.length-1)
            doubleSize();
        heap[++size] = num;
        bubbleUp();
    }
    public int pop () {
        int res = heap[1];
        heap[1] = heap[size];
        heap[size--] = null;
        bubbleDown();
        return res;
    }
    public void bubbleUp () {
        int i = size;
        while (i>1        // terminate util hit root's child
                && heap[i]<heap[i/2]) {
            swap(i, i/2);
            i = i/2;
        }
    }
    public void bubbleDown () {
        int i = 1;
        int tempMin, tempIndex;
        while ((2*i)<heap.length      // in case test some index does not exist yet
                && heap[2*i]!=null)   // terminate when hit the leaf 
        {
             // bubble with smaller child if existed
            if (heap[2*i+1]==null) {
                tempMin = heap[2 * i];
                tempIndex = 2 * i;
            }
            else {
                tempMin = Math.min(heap[2 * i], heap[2 * i + 1]);
                tempIndex = heap[2 * i]<heap[2 * i + 1]?(2*i):(2*i+1);
            }

            if (heap[i]<tempMin)
                break;  // already in-order
            else {
                swap(tempIndex,i);
                i = tempIndex;  // update pointer!
            }
        }
    }
    public void doubleSize() {
        Integer[] old = heap;
        heap = new Integer[heap.length*2];
        System.arraycopy(old,1,heap,1,size);
    }
    protected void swap (int a, int b) {  // use index to swap! not value
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    public String toString() {
        return Arrays.toString(heap);
    }
}
