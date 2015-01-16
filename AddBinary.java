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
}
