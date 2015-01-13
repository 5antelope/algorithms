// reference: http://en.wikipedia.org/wiki/3SUM
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n<3)
            return -1;
        Arrays.sort(num);
        PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();
        for (int i=0; i<n-2; i++) {
            int l = i+1;
            int r = n-1;
            while (l<r) {
                int tmp = num[i]+num[l]+num[r];
                int dif = target-tmp;
                if (dif>0) { // target>tmp
                    queue1.offer(dif);
                    r--;
                }
                else {
                    queue2.offer(dif);
                    l++;
                }
            }
        }
        if (queue1.size()==0){
          return queue2.peek();  
        } 
        else if (queue2.size()==0){
          return queue1.peek();  
        } 
        else {
            int i=queue1.peek();
            int j=queue2.peek();
            if (i+j<0)  return target-i;
            else return target-j;
        }
    }
}
