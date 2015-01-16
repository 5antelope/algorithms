public class Solution {
    // wrong if sum or a or b is greater than Integer.MAX_VALUE.
    public String addBinary(String a, String b) {
        int num1=0, num2=0;
        for (int i=0; i<a.length(); i++) {
            int val = Character.getNumericValue(a.charAt(a.length()-1-i));
            num1 += val*Math.pow(2,i);
        }
        for (int i=0; i<b.length(); i++) {
            int val = Character.getNumericValue(b.charAt(b.length()-1-i));
            num2 += val*Math.pow(2,i);
        }
        return Integer.toBinaryString(num1+num2);
    }
    /*
        AC Version
        1. to it bit by bit
        2. StringBuilder append at tail;
            if wanna add at head, concat strings
        3. a common trick to deal with strings with different length
    */
    public String addBinary(String a, String b) {
        int car = 0;
        int n1 = a.length();
        int n2 = b.length();
        String res = "";
        for (int i=0; i<Math.max(n1,n2); i++) {
            int p,q;
            // a common trick (see also 'Compare Version Number')
            p = i<n1? a.charAt(n1-1-i)-'0': 0;
            q = i<n2? b.charAt(n2-1-i)-'0': 0;
            
            int sum = p+q+car;
            car = sum / 2;
            int r = sum % 2;
            res = r+res;
        }
        if (car==1) return "1"+res;
        else return res;
    }
}
