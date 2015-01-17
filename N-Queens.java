public class Solution {
    int cnt;
    int upper;
    
    public int totalNQueens(int n) {
        cnt = 0;
        upper = (1<<n)-1 ;
        backtrace(0,0,0);         
        return cnt;
    }

    private void backtrace(int row, int ld, int rd){
        int pos, p;
        if(row!=upper) {
            pos = upper & (~(row | ld |rd));
            while(pos!=0){
                p = pos & (-pos);//from right to left, the first "1" in pos
                pos = pos - p;//now take this available as ”Q“，pos kind of like a available slot marker
                backtrace(row+p,(ld+p)<<1,(rd+p)>>1);
            }
        }
        else ++cnt;
    }
}
